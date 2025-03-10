package ca.bc.gov.educ.api.studentgraduation.util;

public class ThreadLocalStateUtil {
    private static InheritableThreadLocal<String> transaction = new InheritableThreadLocal<>();
    private static InheritableThreadLocal<String> user = new InheritableThreadLocal<>();
    private static InheritableThreadLocal<String> requestSource = new InheritableThreadLocal();

    /**
     * Set the current correlationID for this thread
     *
     * @param correlationID
     */
    public static void setCorrelationID(String correlationID){
        transaction.set(correlationID);
    }

    /**
     * Get the current correlationID for this thread
     *
     * @return the correlationID, or null if it is unknown.
     */
    public static String getCorrelationID() {
        return transaction.get();
    }

    /**
     * Set the current user for this thread
     *
     * @param currentUser
     */
    public static void setCurrentUser(String currentUser){
        user.set(currentUser);
    }

    /**
     * Get the current user for this thread
     *
     * @return the username of the current user, or null if it is unknown.
     */
    public static String getCurrentUser() {
        return user.get();
    }

    /**
     * Get the request source for this thread
     *
     * @return the request source
     */
    public static String getRequestSource() {
        return requestSource.get();
    }

    /**
     * Set the request source for this thread
     */
    public static void setRequestSource(String reqSource) {
        requestSource.set(reqSource);
    }

    public static void clear() {
        transaction.remove();
        user.remove();
        requestSource.remove();
    }
}
