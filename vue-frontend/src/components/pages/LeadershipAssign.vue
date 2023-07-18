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
                            >
                                Tickets por asignar
                            </v-btn>
                    </v-col>
                    <v-col align="center">
                            <v-btn
                            variant="outlined"
                            >
                                Tickets por validar
                            </v-btn>
                    </v-col>
                </v-row>
                
                <v-card-text
                align="center"
                >
                    <v-list lines="one">
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
                                            @click="popUp = true"
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
                </v-card-text>
            </v-card>
            <v-dialog v-model="popUp" max-width="500">
                <v-card  class="pa-5 rounded-lg">
                <v-card-title>
                    Seleccione analista a asignar
                </v-card-title>
                <v-card-text>
                    <v-list
                    v-for="analist in listAnalists"
                    :key="analist.idAnalyst"
                    >
                        <v-list-item>
                            <v-list-item-title>
                                {{ analist.name }}
                            </v-list-item-title>
                            <v-list-item-action>
                                <v-btn
                                >
                                    Asignar
                                </v-btn>
                            </v-list-item-action>
                        </v-list-item>
                    </v-list>
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
        name: 'AddTicket',
        data: () => ({
            motivo: null,
            unidad: null,
            descripcion: "",
            comentarios: "",
            clientId: null,
            popUp: false,
            listTickets: [
                {
                idTicket: 1,
                category: "Solicitud",
                description: "Quiero"
                },
                {
                idTicket: 2,
                category: "Incidencia",
                description: "Me quiero cambiar de carrera"
                }
            ],
            listAnalists: [
                {
                    idAnalyst: 1,
                    name: "Analista 1"
                },
                {
                    idAnalyst: 2,
                    name: "Analista 2"
                }
            ]
        }),
        components: {
            appBar
        },
        methods: {
            sendData(){
                axios.post(
                    `http://localhost:8081/tickets/add-ticket/1/`,
                    {
                        description: this.descripcion,
                        category: this.motivo,
                        fkIdAcademicUnit: 16,
                        state: "Sin asignar",
                        fkIdClient: 1
                    }
                ).then(response => {
                    console.log(response.data)
                }).catch(error => {
                    console.error(error)
                })
            }
        },
    }
    
    const instance = axios.create({
        baseURL: 'http://localhost:8081' // URL base con el puerto 8081
    })
</script>
<style>
</style>