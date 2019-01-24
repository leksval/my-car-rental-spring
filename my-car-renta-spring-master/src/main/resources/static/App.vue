<template>
    <div id="app"  >
        <v-app id="app" style="background-color: mintcream;">
            <v-toolbar dark color=#950e32>
                <v-toolbar-side-icon></v-toolbar-side-icon>
                <v-toolbar-title class="white--text"style="font-family: Calibri;">Galactic Car Rental</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn icon>
                    <v-icon>more_vert</v-icon>
                </v-btn>
            </v-toolbar>
    <div :class="[{ flexStart: step === 1 }, 'wrapper']">


        <Claim v-if="step === 0" />
        <v-container >
            <v-layout justify-center>
                <v-flex xs10 sm4 >
                    <div  v-for="car in cars"  style=" background-color: #ececef;">
                        <v-card hover >
                            <v-card-media
                                    :src="car.urlPath"
                                    height="150rh"
                            >
                            </v-card-media>

                            <v-card-title style="font-family: Calibri; font-size: large; padding-bottom: unset; padding-top: unset">
                                <h2 >{{ car.name }} {{ car.model }}</h2>
                            </v-card-title>

                            <v-card-text style=" font-family: Calibri Light; font-size: medium; padding-top: unset;padding-bottom: unset;">

                                Segment: {{ car.segment }} <br>
                                Year: {{ car.manufactureYear }}<br>
                                Number of seats: {{ car.capacity }}<br><br>

                            </v-card-text>

                            <v-card-actions>
                                <v-btn  @click="" outline-success  color=#950e32 class="white--text" font-family= 'Calibri Light'> Rent </v-btn>

                                <v-spacer></v-spacer><b style="font-family: 'Calibri Light'; color:#950e32; font-size: medium">Price: {{ car.price }} PLN</b>
                                <v-btn icon><v-icon >bookmark</v-icon></v-btn>
                            </v-card-actions>

                        </v-card><p></p>
                    </div>
                </v-flex>
            </v-layout>
        </v-container>
        <div class="results" v-if="results && !loading && step === 1">
            <Item v-for="item in results" :item="item" :key="item.data[0].nasa_id" @click.native="handleModalOpen(item)" />
        </div>
        <div class="loader" v-if="step === 1 && loading" />
        <Modal v-if="modalOpen" :item="modalItem" @closeModal="modalOpen = false" />
    </div>
        </v-app>
    </div>
</template>
<script>
    import axios from 'axios';
    import debounce from 'lodash.debounce';
    import Template from '@/components/Template.vue';
    import Items from '@/components/Items.vue';
    import PaymentAccepted from '@/components/PaymentAccepted.vue';
    import PaymentFailed from '@/components/PaymentFailed.vue';

    const API = 'https://images-api.nasa.gov/search';
    export default {
        name: 'App',
        components: {
            Template,
            Items,
            PaymentAccepted,
            PaymentFailed,

        },
        data() {
            return {
                modalOpen: false,
                modalItem: null,
                loading: false,
                step: 0,

                results: [],
            };
        },
        methods: {
            handleModalOpen(item) {
                this.modalOpen = true;
                this.modalItem = item;
            },
            // eslint-disable-next-line
            handleInput: debounce(function() {
                this.loading = true;
                console.log(this.searchValue);
                axios.get(`${API}?q=${this.searchValue}&media_type=image`)
                    .then((response) => {
                        this.results = response.data.collection.items;
                        this.loading = false;
                        this.step = 1;
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            }, 500),
        },
    };
</script>
<style lang="scss">
    @import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,600,800');
    * {
        box-sizing: border-box;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
    body {
        font-family: 'Montserrat', sans-serif;
        margin: 0;
        padding: 0;
    }
    .fade-enter-active, .fade-leave-active {
        transition: opacity .3s ease;
    }
    .fade-enter, .fade-leave-to {
        opacity: 0;
    }
    .slide-enter-active, .slide-leave-active {
        transition: margin-top .3s ease;
    }
    .slide-enter, .slide-leave-to {
        margin-top: -50px;
    }
    .wrapper {
        margin: 0;
        position: relative;
        width: 100%;
        min-height: 100vh;
        padding: 30px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        &.flexStart {
            justify-content: flex-start;
        }
    }
    .loader {
        margin-top: 100px;
        display: inline-block;
        width: 64px;
        height: 64px;
        @media (min-width: 768px) {
            width: 90px;
            height: 90px;
        }
    }
    .loader:after {
        content: " ";
        display: block;
        width: 46px;
        height: 46px;
        margin: 1px;
        border-radius: 50%;
        border: 5px solid #1e3d4a;
        border-color: #1e3d4a transparent #1e3d4a transparent;
        animation: loading 1.2s linear infinite;
        @media (min-width: 768px) {
            width: 90px;
            height: 90px;
        }
    }
    @keyframes loading {
        0% {
            transform: rotate(0deg);
        }
        100% {
            transform: rotate(360deg);
        }
    }
    .logo {
        position: absolute;
        top: 30px;
    }
    .results {
        margin-top: 50px;
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 20px;
        @media (min-width: 768px) {
            width: 90%;
            grid-template-columns: 1fr 1fr 1fr;
        }
    }
</style>