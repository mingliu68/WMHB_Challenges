// `Rate limiting` refers to preventing the frequency of an operation from exceeding a defined
//   limit. For example, a rate limiter for an API might limit the number of API requests that
//   can happen in a certain period of time (e.g. 5 seconds).

//   Write a function that takes in two parameters: an array of numbers that represent timestamps
//   (in seconds) of API requests, and the maximum number of requests allowed in any 5 second
//   window. The function should return an array which is the same length as the input array,
//   where each item is `true` or `false` depending on whether each request was allowed or rejected.

//   Example:
//   allowed_requests(request_timestamps=[1, 2, 2, 2, 6, 12, 32, 33, 34, 37], max_requests=3)
//   [True, True, True, False, False, True, True, True, True, True]

//   The first three requests (t=1, t=2, t=2) are allowed, but the 4th request (t=2) is
//   rejected because there were already three requests in the last two seconds. The 5th request
//   (t=6) is also rejected, because there were three requests that happened 4 seconds ago at t=2,
//   so no more requests are allowed until t=7. The rest of the requests are allowed.


package WhiteBoarding_w2;

import java.util.Arrays;

public class RateLimit {
    public static void main(String[] args) {
        int[] request_timestamps1 = {1, 2, 2, 2, 6, 12, 32, 33, 34, 37};
        System.out.println("\n");
        System.out.println(Arrays.toString(allowed_requests(request_timestamps1, 3)));
        System.out.println("\n");

    }

    public static boolean[] allowed_requests(int[] request_timestamps, int max_requests) {
        
        boolean[] result = new boolean[request_timestamps.length];
        
        if(request_timestamps.length <= max_requests) {
            Arrays.fill(result, true);
            //System.out.println(Arrays.toString(result));
            return result;
        }

        Arrays.fill(result, 0, max_requests, true);
        
        for(int i = max_requests; i < request_timestamps.length; i++) {
            if(request_timestamps[i] - request_timestamps[i-max_requests] >= 5) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
