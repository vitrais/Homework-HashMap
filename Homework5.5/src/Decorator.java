abstract class Component {
    public abstract void operation();
}

class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("Performing component operation");
    }
}

class Decorator extends Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    private void addBehavior() {
        System.out.println("Added behavior A");
    }
}
