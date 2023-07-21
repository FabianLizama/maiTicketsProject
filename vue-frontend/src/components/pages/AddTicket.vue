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
            min-width="600"
            >
                <v-row class="py-1">
                    <v-col cols="12" align="center">
                        <h2 class="text-h4 font-weight-black text-disabled">Añadir Ticket</h2>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-autocomplete
                        label="Motivo" 
                        variant="outlined"
                        v-model="category"
                        :items="['Solicitud', 'Incidencia']"
                        >
                        </v-autocomplete>
                    </v-col>
                    <v-col align="center">
                        <v-autocomplete
                        v-if = academicUnits.length > 0
                        label="Unidad Académica" 
                        variant="outlined"
                        v-model="academicUnit"
                        :items="academicUnits"
                        >
                        </v-autocomplete>
                        <v-autocomplete
                        v-else
                        label="Unidad Académica" 
                        variant="outlined"
                        disabled
                        >
                        </v-autocomplete>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-text-field
                        label="Descripción" 
                        variant="outlined"
                        v-model="description"
                        >
                        </v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-file-input
                        label="Adjuntar Archivo"
                        variant="outlined"
                        >
                        </v-file-input>
                    </v-col>
                </v-row>
                <v-row align-center class="pt-7">
                    <v-col align-center>
                        <v-btn
                        class="rounded-lg text-disabled"
                        block
                        size="large"
                        type="submit"
                        variant="outlined"
                        @click="sendData"
                        >
                        Enviar
                        </v-btn>
                    </v-col>
                </v-row>
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
            category: null,
            academicUnit: null,
            academicUnits: [],
            description: null,
        }),
        components: {
            appBar
        },
        methods: {
            initFetch() {
                // Método inicial, se ejecuta al cargar la página
                // Si hay un usuario logueado, se obtienen las unidades académicas
                // Sino, se redirige a la página de login
                localStorage.getItem('userId')?
                this.getUnits():
                this.$router.push('/login')

            },
            async sendData() {
                // Método para enviar los datos del ticket

                    try {
                    this.clientId = localStorage.getItem('userId')
                    axios.post(
                        `http://localhost:8081/tickets/add-ticket/${idClient}/`,
                        {
                            description: this.descripcion,
                            category: this.category,
                            state: "Sin asignar",
                            fkIdClient: Number(idClient)
                        }
                    ).then(response => {
                        console.log(response.data)
                    }).catch(error => {
                        console.error(error)
                    })

                } catch (error) {
                console.error(error);
                }
            },
            async getUnits(){
                try {
                    const response = await axios.get(`http://localhost:8081/units/names`)
                    this.academicUnits = response.data
                } catch (error){
                    console.error(error)
                }
            }
        },
        mounted() {
            this.initFetch()
        }
    }

</script>
<style>
</style>