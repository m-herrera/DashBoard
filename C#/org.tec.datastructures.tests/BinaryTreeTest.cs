using NUnit.Framework;
using org.tec.datastructures;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class BinaryTreeTest
    {

        [Test()]
        public void AppendTest()
        {
            BinaryTree<int> tree = new BinaryTree<int>();
            Assert.DoesNotThrow(delegate {
                tree.Append(3);
            });
            Assert.DoesNotThrow(delegate {
                tree.Append(5);
            });
            Assert.DoesNotThrow(delegate {
                tree.Append(28);
            });
        }

        [Test()]
        public void GetTest()
        {
            BinaryTree<int> tree = new BinaryTree<int>();
            tree.Append(3);
            Assert.IsNotNull(tree.Get(3));

            Assert.DoesNotThrow(delegate {
                tree.Append(5);
                tree.Get(3);
                tree.Get(5);
            });
            Assert.DoesNotThrow(delegate {
                tree.Append(28);
                tree.Get(3);
                tree.Get(5);
                tree.Get(14);
                tree.Get(28);
            });
            Assert.AreEqual(5, tree.Get(5).value);
            Assert.AreEqual(3, tree.Get(3).value);
            Assert.AreEqual(28, tree.Get(28).value);
        }

        [Test()]
        public void DeleteTest(){
            BinaryTree<int> tree = new BinaryTree<int>();
            tree.Append(5);
            tree.Append(3);
            tree.Append(9);
            tree.Append(14);
            tree.Append(1);
            tree.Append(23);
            tree.Delete(14);
            Assert.IsNull(tree.Get(14));
            tree.Delete(3);
            Assert.IsNull(tree.Get(3));
        }
    }
}
