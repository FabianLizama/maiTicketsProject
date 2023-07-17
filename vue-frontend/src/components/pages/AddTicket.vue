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
            width="40%"
            height="80%"
            class="pa-10"
            style="border-radius: 10px"
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
                        v-model="motivo"
                        :items="['Solicitud', 'Incidencia']"
                        >
                        </v-autocomplete>
                    </v-col>
                    <v-col align="center">
                        <v-autocomplete
                        label="Unidad Académica" 
                        variant="outlined"
                        v-model="unidad"
                        :items="[
                            'Facultad de Administración y Economía',
                            'Facultad de Ciencia',
                            'Facultad de Ciencias Médicas',
                            'Facultad de Derecho',
                            'Facultad de Humanidades',
                            'Facultad de Ingeniería',
                            'Facultad de Química y Biología',
                            'Facultad Tecnológica',
                            'Facultad de Arquitectura y Ambiente',
                            'Programa de Bachillerato'
                            ]"
                        >
                        </v-autocomplete>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-text-field
                        label="Descripción" 
                        variant="outlined"
                        v-model="descripcion"
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
            motivo: null,
            unidad: null,
            descripcion: "",
            comentarios: "",
            clientId: null
        }),
        components: {
            appBar
        },
        methods: {
            sendData(){
                axios.post(
                    `http://localhost:8081/tickets/1/tickets`,
                    {
                        description: this.descripcion,
                        category: this.motivo,
                        state: "Sin asignar",
                    }
                )
            }
        },
    }
    
    const instance = axios.create({
        baseURL: 'http://localhost:8081' // URL base con el puerto 8081
    })
</script>
<style>
</style>