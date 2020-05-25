import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DlinkedNode{
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
        public DlinkedNode (){}//用来生成哨兵节点；
        public DlinkedNode (int _key, int _value){
            key = _key;
            value = _value;
        }

    }
    /*
    * 利用HashMap来存储缓存数据在双向链表中的位置；
    * 哈希表中键就是缓存键值对中的键；而值指向该键值对节点；
    * 双向链表按照使用的顺序来维护所有在缓存中的键值对；
    * */
    private Map<Integer,DlinkedNode>cache = new HashMap<Integer, DlinkedNode>();
    private int size;
    private int capacity;
    private DlinkedNode head,tail;



    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        /*
        * 使用伪头、尾节点,避免一些边界判断（头尾哨兵节点）
        * */
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        /*
        * get操作主要有两步：
        * 一个是判断缓存中是否有该节点，如果没有直接返回-1；
        * 如果有，在返回该节点前还需要把该结点移至双向链表的头部，以便实现LRU缓存机制；
        * */
        DlinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        /*
        * put操作也分两种情况：
        * 1.要放入的节点已经存在：
        *   只需要更新该节点的值即可，不需要判断size是否超过容量；
        * 2.要放入的节点当前不存在：
        *   （其实这里也可以先删去尾部（最久未使用）的节点再进行插入，
        *   不过考虑用的是链表，不存在放不下的情况，也就无所谓了）
        *   先生成一个新节点储存键值对；
        *   然后将该键值对放入Map中，再将其添加到双向链表的头部，然后让size+1；
        *   接着判断size是否超过设置好的容量，如果超过：
        *   在双向链表中删掉尾部节点（同时用一个临时变量保存该结点以便后面删除Map）
        *   根据上面临时变量中的键删掉哈希表中对应的键值对；
        *   同时让size回复原值；
        * */
        DlinkedNode node = cache.get(key);
        if(node == null){
            DlinkedNode temp = new DlinkedNode(key,value);
            cache.put(key,temp);
            addToHead(temp);
            ++size;
            if(size > capacity){
                DlinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }

    }

    private void addToHead(DlinkedNode node){
        /*
        * 简单的双向链表插入操作；
        * */
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        node.prev.next = node;
    }

    private void moveToHead(DlinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DlinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DlinkedNode removeTail(){
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
