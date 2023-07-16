<template>
    <v-layout>
        <v-app-bar
            flat
            class="pa-md-3"
            color="grey"
        >
            <appBar />
        </v-app-bar>
        <v-main>
            <v-container>
        <v-row>
            <v-col cols="6">Columna 1</v-col>
            <v-col cols="6">Columna 2</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Columna 3</v-col>
            <v-col cols="6">Columna 4</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Columna 5</v-col>
            <v-col cols="6">Columna 6</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Columna 7</v-col>
            <v-col cols="6">Columna 8</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Columna 9</v-col>
            <v-col cols="6">Columna 10</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Columna 11</v-col>
            <v-col cols="6">Columna 12</v-col>
        </v-row> 
    </v-container>
        </v-main>
    </v-layout>
    
</template>

<script>
    import appBar from '../appBar.vue'
    export default {
        name: 'AddTicket',
    }
    
</script>

<style>
</style>