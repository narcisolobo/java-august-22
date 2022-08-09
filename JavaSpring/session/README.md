# Session in Spring MVC

## Learning Objectives
- What is Session and Why Do We Need It?
- The HttpSession Object
- Getting and Setting Session Attributes
- Clearing Session
- What Should You Persist in Session?

### What is Session and Why Do We Need It?

---
HTTP is a *stateless* protocol. This means that each request response cycle knows nothing about previous request response cycles. In other words, state does not *persist* from request to request. Have you ever forgotten someone's name instantly after meeting them? Congratulations, you've experienced statelessness.

When a client requests a URL, the server responds with the requested page and then *closes the connection (socket)*. From the server's perspective, each request is unique and isolated from previous requests. This is a good thing. If the socket was left open, server resources would be kept occupied as long as the page was open.

The problem is, developers often need to remember information in subsequent requests. Sometimes we need to identify who made a request in order to serve personalized responses, or to allow access to protected pages. Think about the ubiquitous online shopping cart paradigm. As the user adds products to their cart, we must remember what those items are.

In other words, we want to have a *session*, or a conversation with the user.

### The HttpSession Object

---
On a client's first request, a unique session ID is generated and sent back to the client with the response. This is a temporary session that will be destroyed after a set amount of time expires. If you're curious, you can view this cookie in your inspector, under the Application tab. It's called `JSESSIONID`.

The client then sends back the session ID with each request, making it easier for the server to identify where the request is coming from. The server  uses this ID, finds the matching session, and associates the session with the request.

### Getting and Setting Session Attributes

---
To use session in our web applications, we will use the HttpSession object. Include it as a parameter in any method that needs session:

```java
@GetMapping("/")
public String index(HttpSession session) {
    return "index.jsp";
}
```

Inside our method, we can get or set attributes in the session object using the `getAttribute(String name)` or .`setAttribute(String name, Object value)` methods.