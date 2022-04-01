package model;

import java.util.LinkedList;
import java.util.List;

public class NaryNode {
    public int val;
    public List<NaryNode> children = new LinkedList<>();

    public NaryNode() {
    }

    public NaryNode(int _val) {
        val = _val;
    }

    public NaryNode(int _val, List<NaryNode> _children) {
        val = _val;
        children = _children;
    }
}
