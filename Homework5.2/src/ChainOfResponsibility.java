// Request class definition
class Request {
    private String requestType;
    private double amount;

    public Request(String requestType, double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public String getRequestType() {
        return requestType;
    }

    public double getAmount() {
        return amount;
    }
}

// Abstract handler
abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request);
}

// Concrete handler implementation
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

    private boolean canHandle(Request request) {
        // Logic to check if the request can be handled
        return request.getRequestType().equals("type1");
    }

    private void processRequest(Request request) {
        System.out.println("Handler 1 processed the request for amount " + request.getAmount());
    }
}
