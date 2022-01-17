package fr.gowatch.gowatchback.Security;

public interface SecurityParams {
    public static final String HEADER_NAME="Authorization";
    public static final String SECRET="dibax@ditik";
    public static final long EXPIRATION=10*24*3600*1000;
    public static final String HEADER_PREFIX="Bearer ";
}
