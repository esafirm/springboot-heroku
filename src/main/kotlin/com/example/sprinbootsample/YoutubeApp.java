package com.example.sprinbootsample;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.google.api.services.youtube.model.LiveBroadcastListResponse;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

public class YoutubeApp {

    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;

    /**
     * List broadcasts for the user's channel.
     *
     * @param args command line args (not used).
     */
    public static void main(String[] args) {

        // This OAuth 2.0 access scope allows for read-only access to the
        // authenticated user's account, but not other types of account access.
        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.readonly");

        try {
            // Authorize the request.
            Credential credential = Auth.authorize(scopes, "listbroadcasts");

            // This object is used to make YouTube Data API requests.
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                    .setApplicationName("youtube-cmdline-listbroadcasts-sample").build();

            // Create a request to list broadcasts.
            YouTube.LiveBroadcasts.List liveBroadcastRequest =
                    youtube.liveBroadcasts().list("id,snippet");

            // Indicate that the API response should not filter broadcasts
            // based on their type or status.
            liveBroadcastRequest.setBroadcastType("all").setBroadcastStatus("all");

            // Execute the API request and return the list of broadcasts.
            LiveBroadcastListResponse returnedListResponse = liveBroadcastRequest.execute();
            List<LiveBroadcast> returnedList = returnedListResponse.getItems();

            // Print information from the API response.
            System.out.println("\n================== Returned Broadcasts ==================\n");
            for (LiveBroadcast broadcast : returnedList) {
                System.out.println("  - Id: " + broadcast.getId());
                System.out.println("  - Title: " + broadcast.getSnippet().getTitle());
                System.out.println("  - Description: " + broadcast.getSnippet().getDescription());
                System.out.println("  - Published At: " + broadcast.getSnippet().getPublishedAt());
                System.out.println(
                        "  - Scheduled Start Time: " + broadcast.getSnippet().getScheduledStartTime());
                System.out.println(
                        "  - Scheduled End Time: " + broadcast.getSnippet().getScheduledEndTime());
                System.out.println("\n-------------------------------------------------------------\n");
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t) {
            System.err.println("Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    }
}