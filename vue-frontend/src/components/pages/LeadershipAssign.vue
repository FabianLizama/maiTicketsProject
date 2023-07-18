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
                            v-for="item in items"
                            :key="item.idTicket"
                            variant="outlined"
                            class="py-3 my-3 rounded-lg"
                        >
                            <v-row>
                                <v-col>
                                    <v-list-item-title class="text-left">
                                        ID: {{ item.idTicket }}<br>Motivo: {{ item.category }}
                                    </v-list-item-title>
                                    <v-list-item-subtitle class="text-left">
                                        {{ item.description }}
                                    </v-list-item-subtitle>
                                </v-col>
                                <v-col>
                                    <v-row>
                                        <v-col>
                                            <v-btn>
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
            items: [
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