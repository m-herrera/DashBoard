using System;
namespace org.tec.datastructures
{
    public class DoubleList<T>
    {
        DoubleNode<T> head;
        DoubleNode<T> tail;
        int lenght = 0;

        public void Append(T value)
        {
            if (head == null)
            {
                head = new DoubleNode<T>(value);
                tail = head;
                this.lenght++;
            }
            else
            {
                DoubleNode<T> nodo = head;
                while (nodo.GetNext() != null)
                {
                    nodo = nodo.GetNext();
                }

                nodo.SetNext(new DoubleNode<T>(value));
                tail = nodo.GetNext();
                tail.SetPrev(nodo);

                this.lenght++;

            }
        }

        public void Print()
        {
            DoubleNode<T> temp = this.head;
            while (temp != null)
            {
                Console.WriteLine(temp.GetValue());
                temp = temp.GetNext();
            }
        }

        public void PrintReverse()
        {
            DoubleNode<T> temp = this.tail;
            while (temp != null)
            {
                Console.WriteLine(temp.GetValue());
                temp = temp.GetPrev();
            }
        }

        public void Delete(int index)
        {
            if (index == 0){
                this.head = this.head.GetNext();
                this.head.SetPrev(null);
                return;
            }

            DoubleNode<T> temp = this.head;
            int counter = 1;
            while (temp.GetNext() != null)
            {
                if (counter == index)
                {
                    temp.SetNext(temp.GetNext().GetNext());
                    if (temp.GetNext() != null)
                    {
                        temp.GetNext().SetPrev(temp);
                    }
                    this.lenght--;
                    return;
                }else{
                    temp = temp.GetNext();
                    counter++;
                }
            }
            Console.WriteLine("No se pudo encontrar el elemento");
        }

        public T Get(int index)
        {
            DoubleNode<T> temp = this.head;
            int counter = 0;
            while (temp != null)
            {
                if (counter == index)
                {
                    return temp.GetValue();
                }
                else
                {
                    temp = temp.GetNext();
                    counter++;
                }
            }
            throw new ArgumentOutOfRangeException();
        }

        public Boolean IsEmpty(){
            return this.head == null;
        }

        public int Lenght(){
            return this.lenght;
        }


        public class DoubleNode<T>
        {
            DoubleNode<T> next = null;
            DoubleNode<T> prev = null;
            T value;

            public DoubleNode(T value)
            {
                this.value = value;
            }

            public DoubleNode<T> GetNext()
            {
                return next;
            }

            public void SetNext(DoubleNode<T> node)
            {
                next = node;
            }

            public void SetPrev(DoubleNode<T> node){
                prev = node;
            }

            public DoubleNode<T> GetPrev(){
                return prev;
            }

            public T GetValue()
            {
                return this.value;
            }
        }
    }
}