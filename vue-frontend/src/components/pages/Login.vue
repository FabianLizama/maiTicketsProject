<template>
    <v-app>
        <v-app-bar
            flat
            class="pa-md-3"
            color="grey"
        >
        <appBar />
        </v-app-bar>
        <v-main class="d-flex align-center justify-center">
                <v-card
                    variant="tonal"
                    class="rounded-lg px-10 py-5 align-center text-center"
                    width="500"
                >
                    <div class="py-4 text-h4 font-weight-black text-disabled">
                        Iniciar Sesión
                    </div>
                    <v-text-field 
                        class="pt-5"
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
                            class="rounded-lg "
                            :loading="loading"
                            block
                            size="large"
                            type="submit"
                            @click="login"
                            variant="tonal"

                        >
                        <div class="text-h6 font-weight-bold text-disabled">
                        Ingresar
                        </div>
                    </v-btn>
                    </v-card-actions>
                </v-card>
        </v-main>
    </v-app>
</template>

<script>
    import appBar from '../appBar.vue'
    import axios from 'axios';

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
        },
        methods: {
            async login() {
                try {
                    const response = await axios.post(
                        'http://localhost:8081/api/login',
                        {
                            email: this.email,
                            password: this.password
                        }
                    );

                    const responseStatus = response.data.substring(0, 7);
                    const userId = response.data.substring(7);

                    localStorage.setItem('userId', userId);

                    if (responseStatus === 'loggedC') {
                        this.$router.push()
                    }else if (responseStatus === 'loggedL'){
                        this.$router.push({name: 'assign-ticket', params: {id: userId}});
                    }else{
                        console.log('BBBBBBBB');
                    }

                } catch (error) {
                    console.error('A');
                }
            }
        }
    };
</script>
