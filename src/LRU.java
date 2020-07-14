import java.util.HashMap;

public class LRU<K, V> {

    protected HashMap<K, Node> cacheEntries;//存放当前缓存的条目；
    protected int capacity;//缓存最大条目
    protected Node head;//空的头哨兵节点
    protected Node tail;//指向尾结点，方便删除尾结点；


    private class Node{//LRU中队列节点；
        Node pre ;
        Node next;
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

    }


    public LRU(int capacity){
        this.capacity = capacity;
        cacheEntries = new HashMap<>(capacity);
        head = new Node(null, null);
    }


    protected void remove(Node node){
        if(node.next == null){
            node.pre.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    protected void addFirst(Node node){
        node.next = head.next;
        node.pre = head;
        head.next = node;
        if(node.next == null){
            tail = node;
        }else {
            node.next.pre = node;
        }
    }

    protected void removeLast(){
        Node newTail = tail.pre;
        newTail.next = null;
        tail.pre = null;
        tail = newTail;
    }

    public V get(int key){
        if(cacheEntries.containsKey(key)){
            Node node = cacheEntries.get(key);
            if(tail == node && node.pre != head){
                tail = node.pre;
            }

            remove(node);
            addFirst(node);
            return node.value;

        }

        return null;
    }

    public synchronized V put (K key, V value){
        if(key == null || value == null){
            throw new IllegalArgumentException();
        }

        if(cacheEntries.containsKey(key)){
            Node node = cacheEntries.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
            return null;
        }else{
            V removed = null;
            if(cacheEntries.size() == capacity){
                removed = cacheEntries.remove(tail.key).value;
                removeLast();
            }
            Node node = new Node(key, value);
            addFirst(node);
            cacheEntries.put(key, node);
            return removed;
        }

    }



}
