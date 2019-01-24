<template>
    <form action="https://secure.przelewy24.pl/trnRegister" method="post" class="form">
        <input type="text" name="p24_session_id" value="SESSION_ID" />
        <input type="text" name="p24_merchant_id" value="TWÓJ ID_SPRZEDAWCY" />
        <input type="text" name="p24_pos_id" value="TWÓJ ID_SPRZEDAWCY" />
        <input type="text" name="p24_amount" value="KWOTA W WALUTA/100" />
        <input type="text" name="p24_currency" value="PLN" />
        <input type="text" name="p24_description" value="TYTUŁ" />
        <input type="text" name="p24_client" value="Jan Kowalski" />
        <input type="text" name="p24_address" value="ul. Polska 33/33" />
        <input type="text" name="p24_zip" value="66-777" />
        <input type="text" name="p24_city" value="Poznań" />
        <input type="text" name="p24_country" value="PL" />
        <input type="text" name="p24_email" value="email@host.pl" />
        <input type="text" name="p24_language" value="pl" />
        <input type="text" name="p24_url_return" value="http://myhost.pl/skrypt_ok.php" />
        <input type="text" name="p24_api_version" value="3.2" />
        <input type="hidden" name="p24_sign" value="e2c43dec9578633c518e1f514d3b434b" />
        <input name="submit_send" value="wyślij" type="submit" />
    </form>
</template>
<script>
    export default {
        name: 'Template',
        props: {
            item: {
                type: Object,
                required: true,
            },
        },
        data() {
            return {
                photo: this.item.links[0].href,
                title: this.item.data[0].title,
            };
        },
        computed: {
            style() {
                return `background-image: url("${this.photo}")`;
            },
        },
    };
</script>
<style lang="scss" scoped>
    .item {
        width: 40vw;
        height: 250px;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: 50%;
        @media (min-width: 768px) {
            width: 25vw;
        }
    }
</style>