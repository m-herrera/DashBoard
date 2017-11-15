using System;
using System.Collections;
namespace org.tec.datastructures
{
    public class BinaryTree<T> where T : IComparable<T>
    {
        private BinaryNode<T> root = null;

        public void Append(T value){
            root = AppendAux(root, value);
        }

        private BinaryNode<T> AppendAux(BinaryNode<T> node, T value){
            if (node == null){
                node = new BinaryNode<T>(value);
            }else if(node.value.CompareTo(value) == 1){
                node.left = AppendAux(node.left, value);
            }else if(node.value.CompareTo(value) == -1){
                node.right = AppendAux(node.right, value);
            }
            return node;
        }

        public BinaryNode<T> Get(T value){
            return GetAux(root, value);
        }

        private BinaryNode<T> GetAux(BinaryNode<T> node, T value){
            if (node == null){}
            else if (node.value.CompareTo(value) == 1)
            {
                return GetAux(node.left, value);
            }
            else if (node.value.CompareTo(value) == -1)
            {
                return GetAux(node.right, value);
            }
            return node;
        }

        public void Delete(T value)
        {
            root = DeleteAux(root, value);
        }

        private BinaryNode<T> DeleteAux(BinaryNode<T> node, T value)
        {
            if (node == null){}
            else if (node.value.CompareTo(value) > 0)
            {
                node.left = DeleteAux(node.left, value);
            }
            else if (node.value.CompareTo(value) < 0)
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

        private BinaryNode<T> FindMin(BinaryNode<T> node)
        {
            if (node.left == null)
            {
                return node;
            }
            return FindMin(node.left);
        }
    }

    public class BinaryNode<T>{
        public BinaryNode<T> left = null;
        public BinaryNode<T> right = null;
        public T value;

        public BinaryNode(T value){
            this.value = value;
        }

        public Boolean hasChilden(){
            return left != null || right != null;
        }
    }


}
