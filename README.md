# Network-Operation
Comparison between Asyc-HTTP and Retrofit



This is a simple project which compares the network response time of two famous Networking library used in android 

1. AsyncHttp [ available at http://loopj.com/android-async-http/]
2. retrofit [available at http://square.github.io/retrofit/]

While comparing the two libraries for the response time [which includes the deserialization of the json in java object using Gson]  i think retrofit has a slight upperhand, and that too a little differece only.  

I have calculated the response time by taking the differece of System time before the call and after getting the response.
I dont know whether it is the best method to do so.  

If we assume it as the correct method the response time varies at times sometimes retrofit scores and some time asyc-http scores.

Retrofit has an upperhand in the sence it does not need a seprate ssl certificate for a https call.


NOTE: 
These are all assumptions accrding to my calculation if anyone feels that the method used in here are not the best please feel free to update the code.
