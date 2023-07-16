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
        class="rounded-lg px-10 py-5"
        width="500"
        
        >
          <v-text-field 
            v-model="email"
            placeholder="example@usach.cl"
            size="large"
            label="Correo"
            variant="outlined"
          >
          </v-text-field>
          <v-text-field 
            :type="visible ? 'text' : 'password'"
            v-model="password"
            label="Contraseña"
            variant="outlined"
          >
          </v-text-field>
          <v-card-actions class="px-16">
            <v-btn
              class="rounded-lg"
              :loading="loading"
              block
              size="large"
              type="submit"
              variant="tonal"
              
            >
              Ingresar
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
  data: () => ({
    email: '',
    password: '',
    visible: false,
    loading: false,
    form: false,
  }),
  components: {
    appBar
  }
}
</script>
