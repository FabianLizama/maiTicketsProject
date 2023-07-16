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
      <v-container class="text-center" fluid>
        <v-card
        title="Iniciar Sesión"
        variant="tonal"
        >
          <v-card-actions>
            <v-btn
            color="primary"
            text
            to="/login"
            >
              Iniciar Sesión
            </v-btn>
            <v-btn
            color="primary"
            text
            to="/register"
            >
              Registrarse
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-container>
    </v-main>
  </v-layout>
</template>

<script>
import appBar from './components/appBar.vue'
export default {
  components: {
    appBar
  }
}
</script>
