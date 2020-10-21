﻿using System;
using System.Collections.Generic;
using System.Linq;

public class PriorityQueue<T> where T : IComparable<T>
{
    private List<T> heap; // min heap

    public PriorityQueue()
    {
        this.heap = new List<T>();
    }

    public int Count => this.heap.Count;

    public void Enqueue(T item)
    {
        this.heap.Add(item);
        this.HeapifyUp(this.heap.Count - 1);
    }

    public T Peek()
    {
        if (this.Count <= 0)
        {
            throw new InvalidOperationException();
        }

        return this.heap[0];
    }

    public T Dequeue()
    {
        if (this.Count <= 0)
        {
            throw new InvalidOperationException();
        }

        T item = this.heap[0];

        this.Swap(0, this.heap.Count() - 1);
        this.heap.RemoveAt(this.heap.Count() - 1);
        this.HeapifyDown(0);

        return item;
    }

    // Increases the priority of a key in a MIN binary heap, moving it higher in the heap
    public void DecreaseKey(T item)
    {
        var index = this.heap.IndexOf(item);

        if (index != -1)
        {
            this.HeapifyUp(index);
        }
    }

    private void HeapifyUp(int index)
    {
        while (index > 0 && IsLess(index, Parent(index))) // min heap
        {
            this.Swap(index, Parent(index));
            index = Parent(index);
        }
    }

    private void HeapifyDown(int index)
    {
        while (index < this.heap.Count / 2)
        {
            int child = this.Left(index);
            if (this.HasChild(child + 1) && this.IsLess(child + 1, child)) // min heap
            {
                child = child + 1;
            }

            if (this.IsLess(index, child)) // min heap
            {
                break;
            }

            this.Swap(index, child);
            index = child;
        }
    }

    private bool HasChild(int child)
        => child < this.heap.Count;

    private int Parent(int index)
        => (index - 1) / 2;

    private int Left(int index)
        => 2 * index + 1;

    private int Right(int index)
        => Left(index) + 1;

    private bool IsLess(int a, int b)
        => this.heap[a].CompareTo(this.heap[b]) < 0;

    private void Swap(int a, int b)
    {
        T temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }
}
