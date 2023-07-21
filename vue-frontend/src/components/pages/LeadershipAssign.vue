<template>
    <v-app class="rounded rounded-md">
        <v-app-bar
            flat
            class="pa-md-3"
            color="grey"
        >
            <appBar />
        </v-app-bar>
        <v-main
        class="d-flex align-center justify-center"
        >
            <v-card
            :elevation="10"
            class="pa-10"
            style="border-radius: 10px"
            min-width="1000"
            >
                <v-row justify="center">
                    <v-col align="center">
                            <v-btn
                            variant="outlined"
                            @click="getUnassignedTickets"
                            :active="clickedButton=='unassigned'"
                            >
                                Tickets por asignar
                            </v-btn>
                    </v-col>
                    <v-col align="center">
                            <v-btn
                            variant="outlined"
                            @click="getAnsweredTickets"
                            :active="clickedButton=='answered'"
                            
                            >
                                Tickets por validar
                            </v-btn>
                    </v-col>
                </v-row>
                
                <v-card-text
                align="center"
                class="ma-5"
                >   
                    <v-progress-circular 
                    v-if = "loadingTickets"
                    color="grey"
                    indeterminate
                    >
                    </v-progress-circular>
                    <v-list
                    v-else-if="listTickets.length > 0"
                    lines="one"
                    >
                        <v-list-item
                            v-for="ticket in listTickets"
                            :key="ticket.idTicket"
                            variant="outlined"
                            class="py-3 my-3 rounded-lg"
                        >
                            <v-row>
                                <v-col align="center">
                                    <v-list-item-title class="text-left">
                                        ID: {{ ticket.idTicket }}<br>Motivo: {{ ticket.category }}
                                    </v-list-item-title>
                                    <v-list-item-subtitle class="text-left">
                                        {{ ticket.description }}
                                    </v-list-item-subtitle>
                                </v-col>
                                <v-col class="d-flex align-center">
                                    <v-row justify="space-between" align="center">
                                        <v-col>
                                            <v-btn
                                            @click="openPopup"
                                            >
                                                Asignar
                                            </v-btn>
                                        </v-col>
                                        <v-col>
                                            <v-btn>
                                                Validar
                                            </v-btn>
                                        </v-col>
                                        <v-col>
                                            <v-btn>
                                                Rechazar
                                            </v-btn>
                                        </v-col>
                                    </v-row>
                                </v-col>
                            </v-row>
                        </v-list-item>
                    </v-list>
                    <h3 class="text-disabled" v-else>
                        No hay tickets disponibles
                    </h3>
                </v-card-text>
            </v-card>
            <v-dialog v-model="popUp" max-width="500">
                <v-card  class="pa-5 rounded-lg">
                <v-card-title>
                    Seleccione analista a asignar
                </v-card-title>
                <v-card-text>
                    <v-progress-circular 
                    v-if = "loadingAnalysts"
                    color="grey"
                    indeterminate
                    >
                    </v-progress-circular>
                    <v-list
                    v-else-if = "listAnalyzers.length > 0"
                    v-for="analyzer in listAnalyzers"
                    :key="analyzer.idAnalyzer"
                    >
                        <v-list-item>
                            <v-list-item-title>
                                {{ analyzer.name }}
                            </v-list-item-title>
                            <v-list-item-action>
                                <v-btn
                                >
                                    Asignar
                                </v-btn>
                            </v-list-item-action>
                        </v-list-item>
                    </v-list>
                    <h3 class="text-disabled" v-else>
                        No hay analistas disponibles
                    </h3>
                </v-card-text>
                <v-card-actions>
                    <v-btn @click="popUp = false">Cerrar</v-btn>
                </v-card-actions>
                </v-card>
            </v-dialog>
        </v-main>
    </v-app>
</template>

<script>
    import axios from 'axios'
    import appBar from '../appBar.vue'
    export default {
        name: 'AssignTicket',
        data: () => ({
            motivo: null,
            unidad: null,
            descripcion: '',
            comentarios: '',
            clientId: null,
            popUp: false,
            listTickets: [],
            /*listTickets: [
                {
                    id: 1,
                }
            ],
            */
            listAnalyzers: [],
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
            async openPopup(){
                this.popUp = true
                try {
                    this.getAnalyzers()
                }
                catch (error){
                    console.error(error)
                }
            },

        },
        mounted() {
            this.initFetch();
        }
    }

</script>