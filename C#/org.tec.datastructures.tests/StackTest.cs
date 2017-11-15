using NUnit.Framework;
using System;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class StackTest
    {
        [Test()]
        public void Push()
        {
            Stack<String> stack = new Stack<string>();
            stack.Push("Hola");
            stack.Push("Prueba");
            Assert.IsFalse(stack.IsEmpty());
            Assert.AreEqual("Prueba", stack.Peek());
            Assert.AreEqual("Prueba", stack.Pop());
        }

        [Test()]
        public void Peek()
        {
            Stack<String> stack = new Stack<string>();
            stack.Push("Hola");
            Assert.AreEqual("Hola", stack.Peek());
            stack.Push("Prueba");
            Assert.AreEqual("Prueba", stack.Peek());
        }

        [Test()]
        public void Pop()
        {
            Stack<String> stack = new Stack<string>();
            stack.Push("Hola");
            stack.Push("Prueba");
            Assert.AreEqual("Prueba", stack.Pop());
            Assert.AreEqual("Hola",stack.Pop());
        }
    }
}
