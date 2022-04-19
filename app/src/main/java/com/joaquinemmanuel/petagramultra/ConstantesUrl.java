package com.joaquinemmanuel.petagramultra;

public final class ConstantesUrl {
    public final  static String URL = "https://api.instagram.com/oauth/authorize";
    public final  static  String client_id = "?client_id=483774956720103";
    public final static  String  redirect_uri = "&redirect_uri=https://twitter.com/NightDr86528660";
    public final static  String SCOPES = "&scope=user_profile,user_media";
    public final static String RESPONSE_TYPE = "&response_type=code";
    public final static String REAL_URL = URL+client_id+redirect_uri+SCOPES+RESPONSE_TYPE;

}
