using System;
using System.Collections;
namespace org.tec.datastructures
{
    public class SplayTree<T> where T : IComparable<T>
    {
        SplayNode<T> root = null;

        public void Append(T value){
            root = AppendAux(root, value);

        }

        private SplayNode<T> AppendAux(SplayNode<T> node, T value){
            if (node == null){
                node = new SplayNode<T>(value);
            }else if(node.value.CompareTo(value) == 1){
                node.left = AppendAux(node.left, value);
                node = node.RotateRight();
            }else if(node.value.CompareTo(value) == -1){
                node.right = AppendAux(node.right, value);
                node = node.RotateLeft();
            }
            return node;
        }

        public SplayNode<T> Get(T value){
            root = GetAux(root, value);
            return root;
        }

        private SplayNode<T> GetAux(SplayNode<T> node, T value){
            if (node == null){}
            else if (node.value.CompareTo(value) == 1)
            {
                node = GetAux(node.left, value);
                node.RotateRight();
            }
            else if (node.value.CompareTo(value) == -1)
            {
                node = GetAux(node.right, value);
                node.RotateLeft();
            }
            return node;
        }

        public void Delete(T value)
        {
            root = DeleteAux(root, value);
        }

        private SplayNode<T> DeleteAux(SplayNode<T> node, T value)
        {
            if (node == null) { }
            else if (node.value.CompareTo(value) == 1)
            {
                node.left = DeleteAux(node.left, value);
            }
            else if (node.value.CompareTo(value) == -1)
            {
                node.right = DeleteAux(node.right, value);
            }
            else if (node.left != null && node.right != null)
            {
                T replace = FindMin(node.right).value;

                node.value = replace;
                node.right = DeleteAux(node.right, value);
            }
            else
            {
                node = node.left == null ? node.right : node.left;
            }
            return node;
        }

        private SplayNode<T> FindMin(SplayNode<T> node)
        {
            if (node.left == null)
            {
                return node;
            }
            return FindMin(node.left);
        }

        public SplayNode<T> getRoot()
        {
            return root;
        }
    }

    public class SplayNode<T>{
        public SplayNode<T> left = null;
        public SplayNode<T> right = null;
        public T value;
        public int height;
        public int balance;

        public SplayNode(T value){
            this.value = value;
        }

        public Boolean hasChilden(){
            return left != null || right != null;
        }

        public SplayNode<T> RotateLeft(){
            SplayNode<T> n1 = right;
            right = n1.left;
            n1.left = this;
            return n1;
        }

        public SplayNode<T> RotateRight()
        {
            SplayNode<T> n1 = left;
            left = n1.right;
            n1.right = this;
            return n1;
        }
    }
}
