import java.util.ArrayList;

public class Per_38 {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (!isEmpty()) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    public Object pop() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1);
        }
        return null;
    }

    public void push(Object o) {
        list.add(o);
    }

    public static void main(String[] args) {
        Per_38 stack = new Per_38();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.getSize());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.getSize());

        
    }
}
