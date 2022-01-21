package com.joaquinemmanuel.petagramultra.Constantes;

public final class ConstanteRestApi {
    public static final String ROOTURL = "https://graph.instagram.com";
    public final static String USER_ID = "";
    public static final String KEY_GET_INFORMATION_USER_SCOPE="?fields=id,media_url,username,media_type";
    public static final String KEY_GET_PHOTOS = "/me/media";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String ACCESS_TOKEN = "IGQVJVY1hXSG5FaXpXaFFWQ3hvdWNZAVjFpWFNPdHdsYTc5SGZAxNTE1YTJiWW1sZA05oZAVJweDEtVUQyV25yY3hGTVhEaldfWnFDLVRoNjhGVElTc2VRNER0cG0zQkFzV0RTdS1lVEVYV0ZAGWF9NbXJHdgZDZD";

    public static final String KEY_GET_EVERYTHING = ROOTURL +
            KEY_GET_PHOTOS + KEY_GET_INFORMATION_USER_SCOPE +
            KEY_ACCESS_TOKEN ;

    public static final String KEY_GET_ULTRA = ROOTURL  +
                        KEY_GET_PHOTOS + KEY_GET_INFORMATION_USER_SCOPE  +
                        KEY_ACCESS_TOKEN + ACCESS_TOKEN + "/" ;


}
