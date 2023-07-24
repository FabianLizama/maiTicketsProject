<template>
    <v-app class="rounded rounded-md">
        <v-app-bar
        flat
            class="pa-md-3"
            color="#17a499"
        >
            <appBar />
        </v-app-bar>
        <v-main
        class="d-flex align-center justify-center"
        >
            <v-card
            color="#17a499"
            class="rounded-lg px-10 py-5 align-center text-center"
            :elevation="5"
            min-width="1000"
            >
                <v-row justify="center">
                    <v-col align="center">
                            <v-btn
                            variant="outlined"
                            @click="getUnassignedTickets"
                            :active="clickedButton=='unassigned'"
                            class="rounded-lg text-white px-5"
                            >
                                Tickets por asignar
                            </v-btn>
                    </v-col>
                    <v-col align="center">
                            <v-btn
                            class="rounded-lg text-white px-5"
                            @click="getAnsweredTickets"
                            :active="clickedButton=='answered'"
                            variant="outlined"
                            
                            >
                                <div class="font-weight-medium text-white">
                                    Tickets por validar
                                </div>
                            </v-btn>
                    </v-col>
                </v-row>
                
                <v-card-text
                align="center"
                class="ma-5"
                color="#17a499"
                >   
                    <v-progress-circular 
                    v-if = "loadingTickets"
                    color="white"
                    indeterminate
                    >
                    </v-progress-circular>
                    <v-list
                    v-else-if="listTickets.length > 0"
                    lines="one"
                    base-color="white"
                    bg-color="#17a499"
                    >
                        <v-list-item
                            v-for="ticket in listTickets"
                            :key="ticket.idTicket"
                            variant="outlined"
                            class="py-3 my-3 rounded-lg"
                        >
                            <v-row>
                                <v-col align-center>
                                    <v-list-item-title class="text-left">
                                        ID: {{ ticket.idTicket }}<br>Motivo: {{ ticket.category }}
                                    </v-list-item-title>
                                    <v-list-item-subtitle class="text-left">
                                        {{ ticket.description }}
                                    </v-list-item-subtitle>
                                </v-col>
                                <v-col class="d-flex align-center">
                                    <v-row justify="space-between" >
                                        <v-col>
                                            <v-btn
                                            @click="openPopup(ticket.idTicket)"
                                            variant="text"
                                            >
                                                Asignar
                                            </v-btn>
                                        </v-col>
                                        <v-col>
                                            <v-btn
                                            variant="text"
                                            @click="dontImplemented()"
                                            >
                                                Validar
                                            </v-btn>
                                        </v-col>
                                        <v-col>
                                            <v-btn
                                            variant="text"
                                            >
                                                Rechazar
                                            </v-btn>
                                        </v-col>
                                    </v-row>
                                </v-col>
                            </v-row>
                        </v-list-item>
                    </v-list>
                    <h3 class="text-white" v-else>
                        No hay tickets disponibles
                    </h3>
                </v-card-text>
            </v-card>
            <v-dialog v-model="popUp" max-width="600">
                <v-card  class="d-flex pa-5 rounded-lg align-center" color="#eb7704">
                    <v-card-title>
                        <h3 class="text-white">Seleccione analista a asignar</h3>
                    </v-card-title>
                    <v-card-text>
                        <v-progress-circular 
                        color="white"
                        v-if = "loadingAnalysts"
                        indeterminate
                        >
                        </v-progress-circular>
                        <v-list
                        base-color="white"
                        bg-color="#eb7704"
                        v-else-if = "listAnalyzers.length > 0"
                        v-for="analyzer in listAnalyzers"
                        :key="analyzer.idAnalyzer"
                        >
                            <v-list-item variant="outlined" class="py-3 px-5 my-3 rounded-lg" min-width="400">
                                <v-row>
                                    <v-col class="d-flex align-center">
                                        <v-list-item-title>
                                            {{ analyzer.name }}
                                        </v-list-item-title>
                                    </v-col>
                                    <v-col class="d-flex align-center">
                                        <v-row justify="end" class="text-center pr-3">
                                            <v-list-item-action>
                                                <v-btn
                                                @click="assignTicketToAnalyzer(analyzer.idAnalyzer, this.idTicket)"
                                                variant="text"
                                                size="small"
                                                justify-center
                                                >
                                                <div justify="center">
                                                    Asignar
                                                </div>
                                                </v-btn>
                                            </v-list-item-action>
                                        </v-row>
                                        
                                    </v-col>
                                </v-row>
                                
                                
                            </v-list-item>
                        </v-list>
                        <h3 class="text-white" v-else>
                            No hay analistas disponibles
                        </h3>
                    </v-card-text>
                    <v-card-actions>
                        <v-btn class="font-weight-bold text-white px-3" size="small" @click="popUp = false">Cerrar</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
            <v-dialog v-model="dontImplementedPopUp" max-width="500">
                Funcionalidad no implementada
            </v-dialog>
            <v-dialog v-model="successPopUp" max-width="600" persistent>
                <v-card  class="d-flex pa-5 rounded-lg align-center" color="#eb7704">
                    <v-card-text>
                        <h3 class="text-white">
                            Analista asignado correctamente
                        </h3>
                    </v-card-text>
                    <v-card-actions>
                        <v-btn class="font-weight-bold text-white px-3" size="small" @click="successPopUpClose">Cerrar</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-main>
    </v-app>
</template>

<script>
    import axios from 'axios'
    import appBar from '../appBar.vue'
import { fa } from 'vuetify/lib/locale/index.mjs'
    export default {
        name: 'AssignTicket',
        data: () => ({
            motivo: null,
            unidad: null,
            descripcion: '',
            comentarios: '',
            clientId: null,
            popUp: false,
            successPopUp: false,
            dontImplementedPopUp: false,
            listTickets: [],
            listAnalyzers: [],
            idAnalyzer: null,
            idTicket: null,
            clickedButton: 'unassigned',
            loadingAnalysts: false,
            loadingTickets: false,
        }),
        components: {
            appBar
        },
        methods: {
            initFetch() {
                localStorage.getItem('userId')?
                this.getUnassignedTickets():
                this.$router.push('/login')
            },
            async getUnassignedTickets() {
                try {
                    this.loadingTickets = true
                    this.clickedButton = 'unassigned'
                    const idLeadership = localStorage.getItem('userId')
                    const response = await axios.get(`http://localhost:8081/leaderships/${idLeadership}/tickets-sin-asignar`)
                    this.listTickets = response.data
                    this.loadingTickets = false
                }
                catch (error) {
                    this.loadingTickets = false
                    console.error(error)
                }
            },
            async getAnsweredTickets(){
                try {
                    this.loadingTickets = true
                    this.clickedButton = 'answered'
                    const idLeadership = localStorage.getItem('userId')
                    const response = await axios.get(`http://localhost:8081/leaderships/${idLeadership}/tickets-por-validar`)
                    this.listTickets = response.data
                    this.loadingTickets = false
                }
                catch (error) {
                    this.loadingTickets = false
                    console.error(error)
                }
            },
            async getAnalyzers(){
                try {
                    this.loadingAnalysts = true
                    const idLeadership = localStorage.getItem('userId')
                    const response = await axios.get(`http://localhost:8081/leaderships/${idLeadership}/analyzers`)
                    this.listAnalyzers = response.data
                    this.loadingAnalysts = false
                }
                catch (error){
                    this.loadingAnalysts = false
                    console.error(error)
                }
            },
            async openPopup(idTicket){
                this.idTicket = idTicket;
                this.popUp = true
                try {
                    await this.getAnalyzers();
                }
                catch (error){
                    console.error(error)
                }
            },
            async assignTicketToAnalyzer(idAnalyzer, idTicket){
              try {
                await axios.put(`http://localhost:8081/leaderships/analyzers/${idAnalyzer}/tickets/${idTicket}`);
                this.popUp = false;
                this.successPopUp= true;
              } catch (e) {
                console.error(e);
              }
            },
            dontImplemented(){
                this.dontImplementedPopUp = true
            },
            successPopUpClose(){
                this.successPopUp = false
                window.location.reload()
            }

        },
        mounted() {
            this.initFetch();
        }
    }

</script>