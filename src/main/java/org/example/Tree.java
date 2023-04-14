package org.example;

public class Tree {
    private Worker worker;

    private Tree left;

    private Tree right;

    public Tree(Worker... workers) {
        for (Worker worker : workers) {
            this.addWorker(worker);
        }
    }

    public void addWorker(Worker worker) {
        if (this.worker == null) {
            this.worker = worker;
            return;
        }

        if (worker.getIdnp() > this.worker.getIdnp()) {
            if (this.right == null) {
                this.right = new Tree(worker);
            } else {
                this.right.addWorker(worker);
            }
        } else if (worker.getIdnp() < this.worker.getIdnp()) {
            if (this.left == null) {
                this.left = new Tree(worker);
            } else {
                this.left.addWorker(worker);
            }
        }
    }

    public Worker findWorkerById(long idnp) {
        if (this.worker == null) {
            throw new IllegalStateException("There is no Transaction with such id");
        }
        if (idnp > this.worker.getIdnp()) {
            return this.right.findWorkerById(idnp);
        } else if (idnp < this.worker.getIdnp()) {
            return this.left.findWorkerById(idnp);
        } else {
            return this.worker;
        }
    }

    public Worker getWorker() {
        return worker;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }
}
