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
            <v-sheet 
            :elevation="10"
            width="40%"
            class="px-6 py-3"
            style="border-radius: 10px"
            >
            <v-container>
                <v-row>
                    <v-col cols="12" align="center">
                        <h2 class="text-h4 font-weight-black text-disabled">Añadir Ticket</h2>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-text-field
                        label="Motivo" 
                        variant="outlined"
                        >
                        </v-text-field>
                    </v-col>
                    <v-col align="center">
                        <v-text-field
                        label="Unidad Académica" 
                        variant="outlined"
                        >
                        </v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-textarea
                        label="Descripción" 
                        variant="outlined"
                        >
                        </v-textarea>
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
                <v-row>
                    <v-col align="center">
                        <v-textarea
                        label="Comentarios"
                        variant="outlined"
                        >
                        </v-textarea>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="center">
                        <v-btn
                        class="rounded-lg text-disabled"
                        block
                        size="large"
                        type="submit"
                        variant="outlined"
                        >
                        Enviar
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-sheet>
        </v-main>
    </v-app>
</template>

<script>
    import appBar from '../appBar.vue'
    export default {
        name: 'AddTicket',
        components: {
            appBar
        },
    }
    
</script>

<style>
</style>