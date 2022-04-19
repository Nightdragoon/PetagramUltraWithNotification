package com.joaquinemmanuel.petagramultra.Constantes;

public final class ConstanteRestApi {
    public static final String ROOTURL = "https://graph.instagram.com";
    public final static String USER_ID = "";
    public static final String KEY_GET_INFORMATION_USER_SCOPE="?fields=id,media_url,username,media_type";
    public static final String KEY_GET_PHOTOS = "/me/media";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String ACCESS_TOKEN = "IGQVJXbnZAOemczRHlOYmxwOFFqRG9YY3MxVFZAjWEY1WFU3SE1MajJFcFRnUlpacGhPSDZAnc3FMMnp5ZAW1QUmtJMXlkUjEwMlBodm5kS0p0RzJsU3RaQWk0MHhZATnFIQ2hHd3dZAQ0hBcE1jU3hMcWpQSAZDZD";
    public static final String IMPORTANT = "oauth/access_token";
    public static final String TOKEN_URL = "https://api.instagram.com/";
    public static final String LIKE_URL = "https://infinite-bastion-33440.herokuapp.com";
    public static final String LIKE_SCOPES = "/like_instagram";

    public static final String KEY_GET_EVERYTHING = ROOTURL +
            KEY_GET_PHOTOS + KEY_GET_INFORMATION_USER_SCOPE +
            KEY_ACCESS_TOKEN ;

    public static final String KEY_GET_ULTRA = ROOTURL  +
                        KEY_GET_PHOTOS + KEY_GET_INFORMATION_USER_SCOPE  ;


}
