using System;
namespace org.tec.datastructures
{
    using System;

    public class AVLTree<T> where T : IComparable<T>
    {
        private AVLNode<T> root;

        public void Append(T value)
        {
            this.root = this.AppendAux(this.root, value);
        }

        private AVLNode<T> AppendAux(AVLNode<T> node, T value)
        {
            if (node == null)
            {
                node = new AVLNode<T>(value);
            }else if (node.value.CompareTo(value) == 1)
            {
                node.left = this.AppendAux(node.left, value);
            }else if (node.value.CompareTo(value) == -1)
            {
                node.right = this.AppendAux(node.right, value);
            }
            node = Balance(node);
            return node;
        }

        private AVLNode<T> Balance(AVLNode<T> node)
        {
            if (node == null)
            {
                return null;
            }
            node.calculateHeight();
            if (node.balance == 2)
            {
                if(node.left != null && node.left.balance == -1){
                    node = node.RotateLeftRight();
                }else{
                    node = node.RotateRight();
                }
            }
            else if (node.balance == -2)
            {
                if (node.left != null && node.left.balance == 1)
                {
                    node = node.RotateRightLeft();
                }
                else
                {
                    node = node.RotateLeft();
                }
            }
            node.calculateHeight();
            return node;
        }

        public void Delete(T value)
        {
            this.root = this.DeleteAux(this.root, value);
        }

        private AVLNode<T> DeleteAux(AVLNode<T> node, T value)
        {
            if (node != null){
                
            }else if (node.value.CompareTo(value) == 1)
                {
                    node.left = this.DeleteAux(node.left, value);
                }else if (node.value.CompareTo(value) == -1)
                {
                    node.right = this.DeleteAux(node.right, value);
                }else if ((node.left != null) && (node.right != null))
                {
                    node.value = this.FindMin(node.right).value;
                    node.right = this.DeleteAux(node.right, value);
                }
                node = (node.left == null) ? node.right : node.left;

            node = Balance(node);
            return node;
        }

        private AVLNode<T> FindMin(AVLNode<T> node)
        {
            if (node.left == null)
            {
                return node;
            }
            return this.FindMin(node.left);
        }

        public AVLNode<T> Get(T value) =>
            this.GetAux(this.root, value);

        private AVLNode<T> GetAux(AVLNode<T> node, T value)
        {
            if (node != null)
            {
                if (node.value.CompareTo(value) == -1)
                {
                    node = this.GetAux(node.left, value);
                    return node;
                }
                if (node.value.CompareTo(value) == 1)
                {
                    node = this.GetAux(node.right, value);
                }
            }
            return node;
        }

        public AVLNode<T> getRoot() =>
            this.root;

        private int Height(AVLNode<T> node)
        {
            if (node == null)
            {
                return 0;
            }
            return node.height;
        }
    }

    public class AVLNode<T>
    {
        public int balance;
        public int height;
        public AVLNode<T> left;
        public AVLNode<T> right;
        public T value;

        public AVLNode(T value)
        {
            this.value = value;
        }

        public void calculateHeight()
        {
            if (!this.hasChilden())
            {
                this.height = 0;
                this.balance = 0;
            }
            else
            {
                if (this.left == null)
                {
                    this.height = this.right.height + 1;
                    this.balance = -this.right.height;
                }
                else if (this.right == null)
                {
                    this.height = this.left.height + 1;
                    this.balance = this.left.height;
                }
                else
                {
                    this.height = Math.Max(this.left.height, this.right.height);
                    this.balance = this.left.height - this.right.height;
                }
            }
        }

        public bool hasChilden()
        {
            return left != null || right != null;
        }

        public AVLNode<T> RotateLeft()
        {
            AVLNode<T> right = this.right;
            this.right = right.left;
            right.left = (AVLNode<T>)this;
            this.calculateHeight();
            right.calculateHeight();
            return right;
        }

        public AVLNode<T> RotateLeftRight()
        {
            this.left = this.left.RotateLeft();
            return this.RotateRight();
        }

        public AVLNode<T> RotateRight()
        {
            AVLNode<T> left = this.left;
            this.left = left.right;
            left.right = (AVLNode<T>)this;
            this.calculateHeight();
            left.calculateHeight();
            return left;
        }

        public AVLNode<T> RotateRightLeft()
        {
            this.right = this.right.RotateRight();
            return this.RotateLeft();
        }
    }
}
