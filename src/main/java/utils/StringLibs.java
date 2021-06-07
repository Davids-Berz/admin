package utils;

import org.apache.commons.lang3.StringUtils;

public class StringLibs {
    public static void main(String[] args) {

        String script = "<script type=\"text/javascript\">\n" +
                "    // Instantiate the tracking class\n" +
                "    var rcAnalyticsEvents = new RcAnalyticsEvents();\n" +
                "\n" +
                "    // page controller\n" +
                "    var controllerName = 'product';\n" +
                "    var compliantModules = {\"default\":\"order\",\"supercheckout\":\"supercheckout\",\"onepagecheckoutps\":\"order\",\"sveacheckout\":\"sveapaypage\",\"thecheckout\":\"order\"};\n" +
                "    var compliantModuleName = 'default';\n" +
                "    var skipCartStep = '';\n" +
                "    var isOrder = '';\n" +
                "    var isCheckout = '';\n" +
                "    var isClientId = 0;\n" +
                "    var gaOrder;\n" +
                "    var gaProducts;\n" +
                "    ////////////////////////////\n" +
                "\n" +
                "    // set tracking features\n" +
                "    rcAnalyticsEvents.trackingFeatures = {\"analyticsId\":\"UA-48337167-1\",\"adwordsId\":\"AW-929063544\",\"adwordsCl\":\"wy4XCKHBwGcQ-MSBuwM\",\"productSendRate\":25,\"merchantPrefix\":\"\",\"merchantSuffix\":\"\",\"merchantVariant\":\"\",\"businessDataPrefix\":\"\",\"businessDataVariant\":\"\",\"currency\":\"EUR\",\"idShop\":1,\"productsPerPage\":66,\"cartAjax\":1,\"token\":\"5384d2e2099235659cc40b4728d9b782\",\"disableInternalTracking\":false,\"signUpTypes\":[\"new customer\",\"guest customer\"],\"isNewSignUp\":false,\"isGuest\":0,\"checkDoNotTrack\":1,\"config\":{\"optimizeId\":\"\",\"simpleSpeedSampleRate\":1,\"anonymizeIp\":1,\"linkAttribution\":0,\"userIdFeature\":0,\"userIdValue\":null,\"remarketing\":1,\"crossDomainList\":\"\",\"clientId\":0,\"businessData\":0,\"customDimensions\":{\"ecommProdId\":1,\"ecommPageType\":2,\"ecommTotalValue\":3,\"ecommCategory\":4,\"dynxItemId\":5,\"dynxItemId2\":6,\"dynxPageType\":7,\"dynxTotalValue\":8}},\"goals\":{\"signUp\":0,\"socialAction\":0},\"eventValues\":{\"signUp\":0,\"socialAction\":0}};\n" +
                "\n" +
                "    // set checkout values\n" +
                "    rcAnalyticsEvents.controllerName = controllerName;\n" +
                "    rcAnalyticsEvents.isCheckout = isCheckout;\n" +
                "    rcAnalyticsEvents.compliantModuleName = compliantModuleName;\n" +
                "    rcAnalyticsEvents.skipCartStep = skipCartStep;\n" +
                "\n" +
                "    // list names\n" +
                "    rcAnalyticsEvents.lists = {\"default\":\"accessories\",\"filter\":\"filtered_results\",\"productView\":\"product_page\"};\n" +
                "\n" +
                "    // Google remarketing - page type\n" +
                "    rcAnalyticsEvents.ecommPageType = 'product';\n" +
                "\n" +
                "            // get products list to cache\n" +
                "        rcAnalyticsEvents.productsListCache = {\"90-0\":{\"id\":90,\"id_product\":90,\"id_category_default\":\"312\",\"id_manufacturer\":\"41\",\"id_product_attribute\":\"0\",\"cache_default_attribute\":\"0\",\"name\":\"CUBRE COLCHON AIRE 140 X 70 SORAYA\",\"category\":\"ropa-de-cuna\",\"category_name\":\"Ropa de cuna\",\"reference\":\"BB000014\",\"supplier_reference\":\"\",\"ean13\":\"8436536564358\",\"price_amount\":47.5}};\n" +
                "    \n" +
                "    // Listing products\n" +
                "    \n" +
                "        /////////////////////////////////\n" +
                "\n" +
                "    // init gtag\n" +
                "    rcAnalyticsEvents.sendGtagConfig('analyticsId');\n" +
                "    rcAnalyticsEvents.sendGtagConfig('adwordsId');\n" +
                "    ///////////////////////////////////////////////\n" +
                "\n" +
                "    // Initialize all user events when DOM ready\n" +
                "    document.addEventListener('DOMContentLoaded', initTrackingEvents, false);\n" +
                "    window.addEventListener('pageshow', fireEventsOnPageShow, false);\n" +
                "    ///////////////////////////////////////////////\n" +
                "    function initTrackingEvents() {\n" +
                "        // Events binded on all pages\n" +
                "        // Events binded to document.body to avoid firefox fire events on right/central click\n" +
                "        document.body.addEventListener('click', rcAnalyticsEvents.eventClickPromotionItem, false);\n" +
                "\n" +
                "        // bind prestashop events with tracking events\n" +
                "        prestashop.on(\n" +
                "            'updateCart',\n" +
                "            function (event) {\n" +
                "                rcAnalyticsEvents.eventAddCartProduct(event);\n" +
                "            }\n" +
                "        );\n" +
                "        prestashop.on(\n" +
                "            'clickQuickView',\n" +
                "            function (event) {\n" +
                "                rcAnalyticsEvents.eventProductView(event)\n" +
                "            }\n" +
                "        );\n" +
                "        prestashop.on(\n" +
                "            'updatedProduct',\n" +
                "            function (event) {\n" +
                "                rcAnalyticsEvents.eventProductView(event)\n" +
                "            }\n" +
                "        );\n" +
                "\n" +
                "        if (!isCheckout && !isOrder) {\n" +
                "            // init first scroll action for those products all ready visible on screen\n" +
                "            rcAnalyticsEvents.eventScrollList();\n" +
                "            // bind event to scroll\n" +
                "            window.addEventListener('scroll', rcAnalyticsEvents.eventScrollList, false);\n" +
                "\n" +
                "            // init Event Listeners\n" +
                "            document.body.addEventListener('click', rcAnalyticsEvents.eventClickProductList, false);\n" +
                "\n" +
                "            if (rcAnalyticsEvents.trackingFeatures.goals.socialAction) {\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventSocialShareProductView, false);\n" +
                "            }\n" +
                "            ////////////////////////\n" +
                "            // SEARCH PAGE\n" +
                "            if (controllerName === 'search') {\n" +
                "                rcAnalyticsEvents.onSearchResults();\n" +
                "            }\n" +
                "            ////////////////////////\n" +
                "            // PRODUCT PAGE\n" +
                "            if (controllerName === 'product') {\n" +
                "                // send product detail view\n" +
                "                rcAnalyticsEvents.eventProductView();\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        ////////////////////////\n" +
                "        // CHECKOUT PROCESS\n" +
                "        if (isCheckout) {\n" +
                "            // SUMMARY CART\n" +
                "            if (controllerName === 'cart') {\n" +
                "                // events on summary Cart\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartQuantityDelete, false);\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartQuantityUp, false);\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartQuantityDown, false);\n" +
                "            }\n" +
                "            ////////////////////////\n" +
                "            // CHECKOUT\n" +
                "            if (!compliantModuleName && controllerName === 'order') {\n" +
                "                // Events on Checkout Process\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventPrestashopCheckout, false);\n" +
                "            } else if (\n" +
                "                compliantModuleName === 'supercheckout'\n" +
                "                && controllerName === compliantModules[compliantModuleName]\n" +
                "            ) {\n" +
                "                // Compatible with super-checkout by Knowband\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventOpcSuperCheckout, false);\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartOpcSuperCheckout, false);\n" +
                "            } else if (\n" +
                "                compliantModuleName === 'onepagecheckoutps'\n" +
                "                && controllerName === compliantModules[compliantModuleName]\n" +
                "            ) {\n" +
                "                // compatible with OPC by PrestaTeamShop\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventOpcPrestaTeam, false);\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartOpcPrestaTeam, false);\n" +
                "            } else if (\n" +
                "                compliantModuleName === 'thecheckout'\n" +
                "                && controllerName === compliantModules[compliantModuleName]\n" +
                "            ) {\n" +
                "                // Compatible with thecheckout by Zelarg\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventOpcTheCheckout, false);\n" +
                "                document.body.addEventListener('click', rcAnalyticsEvents.eventCartOpcTheCheckout, false);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    function fireEventsOnPageShow(event){\n" +
                "        // fixes safari back cache button\n" +
                "        if (event.persisted) {\n" +
                "            window.location.reload()\n" +
                "        }\n" +
                "\n" +
                "        // Sign up feature\n" +
                "        if (rcAnalyticsEvents.trackingFeatures.goals.signUp && rcAnalyticsEvents.trackingFeatures.isNewSignUp) {\n" +
                "            rcAnalyticsEvents.onSignUp();\n" +
                "        }\n" +
                "\n" +
                "        if (isClientId) {\n" +
                "            rcAnalyticsEvents.setClientId();\n" +
                "        }\n" +
                "\n" +
                "        // Checkout and order complete\n" +
                "        if (isCheckout && gaProducts) {\n" +
                "            rcAnalyticsEvents.onCheckoutProducts(gaProducts);\n" +
                "        } else if (isOrder && gaOrder && gaProducts) {\n" +
                "            rcAnalyticsEvents.onAddOrder(gaOrder, gaProducts, rcAnalyticsEvents.trackingFeatures.idShop);\n" +
                "        }\n" +
                "    }\n" +
                "</script>";


        String rawJson = StringUtils.substringBetween(script, "productsListCache = ", ";");

        System.out.println("rawJson = " + rawJson);

    }
}
