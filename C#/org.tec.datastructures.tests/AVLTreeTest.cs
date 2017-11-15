using NUnit.Framework;
using System;
using org.tec.datastructures;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class AVLTreeTest
    {
        [Test()]
        public void AppendTest()
        {
            AVLTree<int> tree = new AVLTree<int>();
            tree.Append(20);
            Assert.AreEqual(20, tree.getRoot().value);

            tree.Append(30);
            Assert.AreEqual(20, tree.getRoot().value);
            Assert.AreEqual(30, tree.getRoot().right.value);

            tree.Append(40);
            Assert.AreEqual(30, tree.getRoot().value);

            tree.Append(0);
            tree.Append(10);
            Assert.AreEqual(10, tree.getRoot().left.value);
            Assert.AreEqual(0, tree.getRoot().left.left.value);
            Assert.AreEqual(20, tree.getRoot().left.right.value);
        }

        [Test()]
        public void GetTest()
        {
            AVLTree<int> tree = new AVLTree<int>();
            tree.Append(20);
            tree.Append(30);
            tree.Append(40);
            tree.Append(0);
            tree.Append(10);
            Assert.AreEqual(10, tree.Get(10).value);
            Assert.AreEqual(0, tree.Get(0).value);
            Assert.AreEqual(40, tree.Get(40).value);
        }

        [Test()]
        public void DeleteTest()
        {
            AVLTree<int> tree = new AVLTree<int>();
            tree.Append(20);
            tree.Append(30);
            tree.Append(40);
            tree.Append(0);
            tree.Append(10);
            tree.Delete(40);
            Assert.AreEqual(10, tree.getRoot().value);
            Assert.AreEqual(30, tree.getRoot().right.value);
            Assert.DoesNotThrow(delegate
            {
                tree.Delete(40);
            });
            tree.Delete(0);
            Assert.AreEqual(20, tree.getRoot().value);
            Assert.AreEqual(30, tree.getRoot().right.value);
            Assert.AreEqual(10, tree.getRoot().left.value);
        }
    }
}
