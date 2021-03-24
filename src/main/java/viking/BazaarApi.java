package viking;

public class BazaarApi {

    public static void main(String[] args) {

        String url = "https://api.bazaarvoice.com/data/batch.json?passkey=lsksbqg7byc98mqfcy4d03vbm"
                + "&apiversion=5.5"
                + "&displaycode=17574-de_de"
                + "&resource.q0=products"
                + "&filter.q0=id%3Aeq%3A{SKU}"
                + "&stats.q0=reviews"
                + "&filteredstats.q0=reviews"
                + "&filter_reviews.q0=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&filter_reviewcomments.q0=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&resource.q1=reviews"
                + "&filter.q1=isratingsonly%3Aeq%3Afalse"
                + "&filter.q1=productid%3Aeq%3A{SKU}"
                + "&filter.q1=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&sort.q1=relevancy%3Aa1"
                + "&stats.q1=reviews"
                + "&filteredstats.q1=reviews"
                + "&include.q1=authors%2Cproducts%2Ccomments"
                + "&filter_reviews.q1=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&filter_reviewcomments.q1=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&filter_comments.q1=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&limit.q1=8"
                + "&offset.q1=0"
                + "&limit_comments.q1=3"
                + "&resource.q2=reviews"
                + "&filter.q2=productid%3Aeq%3A{SKU}"
                + "&filter.q2=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&limit.q2=1"
                + "&resource.q3=reviews"
                + "&filter.q3=productid%3Aeq%3A{SKU}"
                + "&filter.q3=isratingsonly%3Aeq%3Afalse"
                + "&filter.q3=issyndicated%3Aeq%3Afalse"
                + "&filter.q3=rating%3Agt%3A3"
                + "&filter.q3=totalpositivefeedbackcount%3Agte%3A3"
                + "&filter.q3=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&sort.q3=totalpositivefeedbackcount%3Adesc"
                + "&include.q3=authors%2Creviews%2Cproducts"
                + "&filter_reviews.q3=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&limit.q3=1"
                + "&resource.q4=reviews"
                + "&filter.q4=productid%3Aeq%3A{SKU}"
                + "&filter.q4=isratingsonly%3Aeq%3Afalse"
                + "&filter.q4=issyndicated%3Aeq%3Afalse"
                + "&filter.q4=rating%3Alte%3A3"
                + "&filter.q4=totalpositivefeedbackcount%3Agte%3A3"
                + "&filter.q4=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&sort.q4=totalpositivefeedbackcount%3Adesc"
                + "&include.q4=authors%2Creviews%2Cproducts"
                + "&filter_reviews.q4=contentlocale%3Aeq%3Ade*%2Cde_DE"
                + "&limit.q4=1"
                + "&callback=BV._internal.dataHandler0";

        String urlBefore = "https://api.bazaarvoice.com/data/batch.json?passkey=lsksbqg7byc98mqfcy4d03vbm&apiversion=5.5&displaycode=17574-de_de&resource.q0=products&filter.q0=id%3Aeq%3A{SKU}&stats.q0=reviews&filteredstats.q0=reviews&filter_reviews.q0=contentlocale%3Aeq%3Ade*%2Cde_DE&filter_reviewcomments.q0=contentlocale%3Aeq%3Ade*%2Cde_DE&resource.q1=reviews&filter.q1=isratingsonly%3Aeq%3Afalse&filter.q1=productid%3Aeq%3A{SKU}&filter.q1=contentlocale%3Aeq%3Ade*%2Cde_DE&sort.q1=relevancy%3Aa1&stats.q1=reviews&filteredstats.q1=reviews&include.q1=authors%2Cproducts%2Ccomments&filter_reviews.q1=contentlocale%3Aeq%3Ade*%2Cde_DE&filter_reviewcomments.q1=contentlocale%3Aeq%3Ade*%2Cde_DE&filter_comments.q1=contentlocale%3Aeq%3Ade*%2Cde_DE&limit.q1=8&offset.q1=0&limit_comments.q1=3&resource.q2=reviews&filter.q2=productid%3Aeq%3A{SKU}&filter.q2=contentlocale%3Aeq%3Ade*%2Cde_DE&limit.q2=1&resource.q3=reviews&filter.q3=productid%3Aeq%3A{SKU}&filter.q3=isratingsonly%3Aeq%3Afalse&filter.q3=issyndicated%3Aeq%3Afalse&filter.q3=rating%3Agt%3A3&filter.q3=totalpositivefeedbackcount%3Agte%3A3&filter.q3=contentlocale%3Aeq%3Ade*%2Cde_DE&sort.q3=totalpositivefeedbackcount%3Adesc&include.q3=authors%2Creviews%2Cproducts&filter_reviews.q3=contentlocale%3Aeq%3Ade*%2Cde_DE&limit.q3=1&resource.q4=reviews&filter.q4=productid%3Aeq%3A{SKU}&filter.q4=isratingsonly%3Aeq%3Afalse&filter.q4=issyndicated%3Aeq%3Afalse&filter.q4=rating%3Alte%3A3&filter.q4=totalpositivefeedbackcount%3Agte%3A3&filter.q4=contentlocale%3Aeq%3Ade*%2Cde_DE&sort.q4=totalpositivefeedbackcount%3Adesc&include.q4=authors%2Creviews%2Cproducts&filter_reviews.q4=contentlocale%3Aeq%3Ade*%2Cde_DE&limit.q4=1&callback=BV._internal.dataHandler0";

        System.out.println(url);
    }
}
