

public class ArvoreAVL {
        public Node raiz;

        public void inserir(String palavra) { raiz = inserirRecursivo(raiz, palavra); }
        private Node inserirRecursivo(Node node, String palavra) {
            if (node == null) return new Node(palavra);
                int comp = palavra.compareToIgnoreCase(node.palavra);
            if (comp < 0) node.esq = inserirRecursivo(node.esq, palavra);
                else if (comp > 0) node.dir = inserirRecursivo(node.dir, palavra);
                    else return node;//ignora as duplicatas

            node.altura = 1 + Math.max(getAlt(node.esq), getAlt(node.dir));
            return balancear(node, palavra);
        }

        public String calcularHashes(Node no) {
            if (no == null) return "";
            
            String hEsq = calcularHashes(no.esq);
            String hDir = calcularHashes(no.dir);
            String hProprio = SHA1.gerarSHA1(no.palavra);

            no.hashNode = SHA1.gerarSHA1(hEsq + hDir + hProprio);
            return no.hashNode;
        }
        //Balanceamento
        private int getAlt(Node n) { return n == null ? 0 : n.altura; }
        private Node balancear(Node n, String p) {
            int bal = getAlt(n.esq) - getAlt(n.dir);
            if (bal > 1 && p.compareToIgnoreCase(n.esq.palavra) < 0) return rotDir(n);
            if (bal < -1 && p.compareToIgnoreCase(n.dir.palavra) > 0) return rotEsq(n);
            if (bal > 1 && p.compareToIgnoreCase(n.esq.palavra) > 0) {
                n.esq = rotEsq(n.esq); return rotDir(n);
            }
            if (bal < -1 && p.compareToIgnoreCase(n.dir.palavra) < 0) {
                n.dir = rotDir(n.dir); return rotEsq(n);
            }
            return n;
        }
        //Rotação
        private Node rotDir(Node y) {
            Node x = y.esq; Node t2 = x.dir;
            x.dir = y; y.esq = t2;
            y.altura = Math.max(getAlt(y.esq), getAlt(y.dir)) + 1;
            x.altura = Math.max(getAlt(x.esq), getAlt(x.dir)) + 1;
            return x;
        }

        private Node rotEsq(Node x) {
            Node y = x.dir; Node t2 = y.esq;
            y.esq = x; x.dir = t2;
            x.altura = Math.max(getAlt(x.esq), getAlt(x.dir)) + 1;
            y.altura = Math.max(getAlt(y.esq), getAlt(y.dir)) + 1;
            return y;
        }   
        
    }

    
