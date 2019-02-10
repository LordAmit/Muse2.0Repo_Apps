/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.Comparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A ComparatorChain is a Comparator that wraps one or more Comparators in
 * sequence. The ComparatorChain calls each Comparator in sequence until either
 * 1) any single Comparator returns a non-zero result (and that result is then
 * returned), or 2) the ComparatorChain is exhausted (and zero is returned).
 * This type of sorting is very similar to multi-column sorting in SQL, and this
 * class allows Java classes to emulate that kind of behaviour when sorting a
 * List.
 * <p>
 * To further facilitate SQL-like sorting, the order of any single Comparator in
 * the list can be reversed.
 * <p>
 * Calling a method that adds new Comparators or changes the ascend/descend sort
 * <i>after compare(Object, Object) has been called</i> will result in an
 * UnsupportedOperationException. However, <i>take care</i> to not alter the
 * underlying List of Comparators or the BitSet that defines the sort order.
 * <p>
 * Instances of ComparatorChain are not synchronized. The class is not
 * thread-safe at construction time, but it <i>is</i> thread-safe to perform
 * multiple comparisons after all the setup operations are complete.
 *
 * @since 2.0
 * @version $Id$
 */

public class ComparatorChain<E> implements Comparator<E>, Serializable {

    String dataLeAk20 = "";

	String dataLeAk19 = "";

	String dataLeAk18 = "";

	String dataLeAk17 = "";

	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk10 = "";

	String dataLeAk9 = "";

	String dataLeAk8 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk5 = "";

	String dataLeAk4 = "";

	String dataLeAk3 = "";

	String dataLeAk2 = "";

	/** Serialization version from Collections 2.0. */
    private static final long serialVersionUID = -721644942746081630L;

    /** The list of comparators in the chain. */
    protected List<Comparator<E>> comparatorChain = null;
    /** Order - false (clear) = ascend; true (set) = descend. */
    protected BitSet orderingBits = null;
    /** Whether the chain has been "locked". */
    protected boolean isLocked = false;

    //-----------------------------------------------------------------------
    /**
     * Construct a ComparatorChain with no Comparators.
     * You must add at least one Comparator before calling
     * the compare(Object,Object) method, or an
     * UnsupportedOperationException is thrown
     */
    public ComparatorChain() {
        this(new ArrayList<Comparator<E>>(), new BitSet());
		dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-18-0", dataLeAk18);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
    }

    /**
     * Construct a ComparatorChain with a single Comparator,
     * sorting in the forward order
     *
     * @param comparator First comparator in the Comparator chain
     */
    public ComparatorChain(Comparator<E> comparator) {
        this(comparator, false);
		dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-18-1", dataLeAk18);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
    }

    /**
     * Construct a Comparator chain with a single Comparator,
     * sorting in the given order
     *
     * @param comparator First Comparator in the ComparatorChain
     * @param reverse    false = forward sort; true = reverse sort
     */
    public ComparatorChain(Comparator<E> comparator, boolean reverse) {
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-18-2", dataLeAk18);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		comparatorChain = new ArrayList<Comparator<E>>(1);
        comparatorChain.add(comparator);
        orderingBits = new BitSet(1);
        if (reverse == true) {
            orderingBits.set(0);
        }
    }

    /**
     * Construct a ComparatorChain from the Comparators in the
     * List.  All Comparators will default to the forward
     * sort order.
     *
     * @param list   List of Comparators
     * @see #ComparatorChain(List,BitSet)
     */
    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-18-3", dataLeAk18);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
    }

    /**
     * Construct a ComparatorChain from the Comparators in the
     * given List.  The sort order of each column will be
     * drawn from the given BitSet.  When determining the sort
     * order for Comparator at index <i>i</i> in the List,
     * the ComparatorChain will call BitSet.get(<i>i</i>).
     * If that method returns <i>false</i>, the forward
     * sort order is used; a return value of <i>true</i>
     * indicates reverse sort order.
     *
     * @param list   List of Comparators.  NOTE: This constructor does not perform a
     *               defensive copy of the list
     * @param bits   Sort order for each Comparator.  Extra bits are ignored,
     *               unless extra Comparators are added by another method.
     */
    public ComparatorChain(List<Comparator<E>> list, BitSet bits) {
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-4", dataLeAk2);
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-16-4", dataLeAk16);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-18-4", dataLeAk18);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		comparatorChain = list;
        orderingBits = bits;
    }

    //-----------------------------------------------------------------------
    /**
     * Add a Comparator to the end of the chain using the
     * forward sort order
     *
     * @param comparator Comparator with the forward sort order
     */
    public void addComparator(Comparator<E> comparator) {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-5", dataLeAk2);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-18-5", dataLeAk18);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-20-5", dataLeAk20);
		addComparator(comparator, false);
    }

    /**
     * Add a Comparator to the end of the chain using the
     * given sort order
     *
     * @param comparator Comparator to add to the end of the chain
     * @param reverse    false = forward sort order; true = reverse sort order
     */
    public void addComparator(Comparator<E> comparator, boolean reverse) {
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-6", dataLeAk2);
		android.util.Log.d("leak-3-6", dataLeAk3);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-5-6", dataLeAk5);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-7-6", dataLeAk7);
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-16-6", dataLeAk16);
		android.util.Log.d("leak-17-6", dataLeAk17);
		android.util.Log.d("leak-18-6", dataLeAk18);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-20-6", dataLeAk20);
		checkLocked();

        comparatorChain.add(comparator);
        if (reverse == true) {
            orderingBits.set(comparatorChain.size() - 1);
        }
    }

    /**
     * Replace the Comparator at the given index, maintaining
     * the existing sort order.
     *
     * @param index      index of the Comparator to replace
     * @param comparator Comparator to place at the given index
     * @exception IndexOutOfBoundsException
     *                   if index &lt; 0 or index &gt;= size()
     */
    public void setComparator(int index, Comparator<E> comparator) throws IndexOutOfBoundsException {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-7", dataLeAk2);
		android.util.Log.d("leak-3-7", dataLeAk3);
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-5-7", dataLeAk5);
		android.util.Log.d("leak-6-7", dataLeAk6);
		android.util.Log.d("leak-7-7", dataLeAk7);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-16-7", dataLeAk16);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-18-7", dataLeAk18);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-20-7", dataLeAk20);
		setComparator(index, comparator, false);
    }

    /**
     * Replace the Comparator at the given index in the
     * ComparatorChain, using the given sort order
     *
     * @param index      index of the Comparator to replace
     * @param comparator Comparator to set
     * @param reverse    false = forward sort order; true = reverse sort order
     */
    public void setComparator(int index, Comparator<E> comparator, boolean reverse) {
        dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-8", dataLeAk2);
		android.util.Log.d("leak-3-8", dataLeAk3);
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-6-8", dataLeAk6);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-16-8", dataLeAk16);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-18-8", dataLeAk18);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		checkLocked();

        comparatorChain.set(index,comparator);
        if (reverse == true) {
            orderingBits.set(index);
        } else {
            orderingBits.clear(index);
        }
    }

    /**
     * Change the sort order at the given index in the
     * ComparatorChain to a forward sort.
     *
     * @param index  Index of the ComparatorChain
     */
    public void setForwardSort(int index) {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-9", dataLeAk2);
		android.util.Log.d("leak-3-9", dataLeAk3);
		android.util.Log.d("leak-4-9", dataLeAk4);
		android.util.Log.d("leak-5-9", dataLeAk5);
		android.util.Log.d("leak-6-9", dataLeAk6);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-12-9", dataLeAk12);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-15-9", dataLeAk15);
		android.util.Log.d("leak-16-9", dataLeAk16);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-18-9", dataLeAk18);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		checkLocked();
        orderingBits.clear(index);
    }

    /**
     * Change the sort order at the given index in the
     * ComparatorChain to a reverse sort.
     *
     * @param index  Index of the ComparatorChain
     */
    public void setReverseSort(int index) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-10", dataLeAk2);
		android.util.Log.d("leak-3-10", dataLeAk3);
		android.util.Log.d("leak-4-10", dataLeAk4);
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-6-10", dataLeAk6);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		checkLocked();
        orderingBits.set(index);
    }

    /**
     * Number of Comparators in the current ComparatorChain.
     *
     * @return Comparator count
     */
    public int size() {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-11", dataLeAk2);
		android.util.Log.d("leak-3-11", dataLeAk3);
		android.util.Log.d("leak-4-11", dataLeAk4);
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-6-11", dataLeAk6);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		return comparatorChain.size();
    }

    /**
     * Determine if modifications can still be made to the
     * ComparatorChain.  ComparatorChains cannot be modified
     * once they have performed a comparison.
     *
     * @return true = ComparatorChain cannot be modified; false =
     *         ComparatorChain can still be modified.
     */
    public boolean isLocked() {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-12", dataLeAk2);
		android.util.Log.d("leak-3-12", dataLeAk3);
		android.util.Log.d("leak-4-12", dataLeAk4);
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-6-12", dataLeAk6);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-10-12", dataLeAk10);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-12-12", dataLeAk12);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-18-12", dataLeAk18);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-20-12", dataLeAk20);
		return isLocked;
    }

    /**
     * Throws an exception if the {@link ComparatorChain} is locked.
     *
     * @throws UnsupportedOperationException if the {@link ComparatorChain} is locked
     */
    private void checkLocked() {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-13", dataLeAk2);
		android.util.Log.d("leak-3-13", dataLeAk3);
		android.util.Log.d("leak-4-13", dataLeAk4);
		android.util.Log.d("leak-5-13", dataLeAk5);
		android.util.Log.d("leak-6-13", dataLeAk6);
		android.util.Log.d("leak-7-13", dataLeAk7);
		android.util.Log.d("leak-8-13", dataLeAk8);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-10-13", dataLeAk10);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-12-13", dataLeAk12);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-16-13", dataLeAk16);
		android.util.Log.d("leak-17-13", dataLeAk17);
		android.util.Log.d("leak-18-13", dataLeAk18);
		android.util.Log.d("leak-19-13", dataLeAk19);
		android.util.Log.d("leak-20-13", dataLeAk20);
		if (isLocked == true) {
            throw new UnsupportedOperationException(
                "Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    /**
     * Throws an exception if the {@link ComparatorChain} is empty.
     *
     * @throws UnsupportedOperationException if the {@link ComparatorChain} is empty
     */
    private void checkChainIntegrity() {
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-14", dataLeAk2);
		android.util.Log.d("leak-3-14", dataLeAk3);
		android.util.Log.d("leak-4-14", dataLeAk4);
		android.util.Log.d("leak-5-14", dataLeAk5);
		android.util.Log.d("leak-6-14", dataLeAk6);
		android.util.Log.d("leak-7-14", dataLeAk7);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-10-14", dataLeAk10);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-12-14", dataLeAk12);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-14-14", dataLeAk14);
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-16-14", dataLeAk16);
		android.util.Log.d("leak-17-14", dataLeAk17);
		android.util.Log.d("leak-18-14", dataLeAk18);
		android.util.Log.d("leak-19-14", dataLeAk19);
		android.util.Log.d("leak-20-14", dataLeAk20);
		if (comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Perform comparisons on the Objects as per
     * Comparator.compare(o1,o2).
     *
     * @param o1  the first object to compare
     * @param o2  the second object to compare
     * @return -1, 0, or 1
     * @exception UnsupportedOperationException
     *                   if the ComparatorChain does not contain at least one
     *                   Comparator
     */
    public int compare(E o1, E o2) throws UnsupportedOperationException {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-15", dataLeAk2);
		android.util.Log.d("leak-3-15", dataLeAk3);
		android.util.Log.d("leak-4-15", dataLeAk4);
		android.util.Log.d("leak-5-15", dataLeAk5);
		android.util.Log.d("leak-6-15", dataLeAk6);
		android.util.Log.d("leak-7-15", dataLeAk7);
		android.util.Log.d("leak-8-15", dataLeAk8);
		android.util.Log.d("leak-9-15", dataLeAk9);
		android.util.Log.d("leak-10-15", dataLeAk10);
		android.util.Log.d("leak-11-15", dataLeAk11);
		android.util.Log.d("leak-12-15", dataLeAk12);
		android.util.Log.d("leak-13-15", dataLeAk13);
		android.util.Log.d("leak-14-15", dataLeAk14);
		android.util.Log.d("leak-15-15", dataLeAk15);
		android.util.Log.d("leak-16-15", dataLeAk16);
		android.util.Log.d("leak-17-15", dataLeAk17);
		android.util.Log.d("leak-18-15", dataLeAk18);
		android.util.Log.d("leak-19-15", dataLeAk19);
		android.util.Log.d("leak-20-15", dataLeAk20);
		if (isLocked == false) {
            checkChainIntegrity();
            isLocked = true;
        }

        // iterate over all comparators in the chain
        Iterator<Comparator<E>> comparators = comparatorChain.iterator();
        for (int comparatorIndex = 0; comparators.hasNext(); ++comparatorIndex) {

            Comparator<E> comparator = comparators.next();
            int retval = comparator.compare(o1,o2);
            if (retval != 0) {
                // invert the order if it is a reverse sort
                if (orderingBits.get(comparatorIndex) == true) {
                    if(Integer.MIN_VALUE == retval) {
                        retval = Integer.MAX_VALUE;
                    } else {
                        retval *= -1;
                    }
                }
                return retval;
            }
        }

        // if comparators are exhausted, return 0
        return 0;
    }

    //-----------------------------------------------------------------------
    /**
     * Implement a hash code for this comparator that is consistent with
     * {@link #equals(Object) equals}.
     *
     * @return a suitable hash code
     * @since 3.0
     */
    @Override
    public int hashCode() {
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-16", dataLeAk2);
		android.util.Log.d("leak-3-16", dataLeAk3);
		android.util.Log.d("leak-4-16", dataLeAk4);
		android.util.Log.d("leak-5-16", dataLeAk5);
		android.util.Log.d("leak-6-16", dataLeAk6);
		android.util.Log.d("leak-7-16", dataLeAk7);
		android.util.Log.d("leak-8-16", dataLeAk8);
		android.util.Log.d("leak-9-16", dataLeAk9);
		android.util.Log.d("leak-10-16", dataLeAk10);
		android.util.Log.d("leak-11-16", dataLeAk11);
		android.util.Log.d("leak-12-16", dataLeAk12);
		android.util.Log.d("leak-13-16", dataLeAk13);
		android.util.Log.d("leak-14-16", dataLeAk14);
		android.util.Log.d("leak-15-16", dataLeAk15);
		android.util.Log.d("leak-16-16", dataLeAk16);
		android.util.Log.d("leak-17-16", dataLeAk17);
		android.util.Log.d("leak-18-16", dataLeAk18);
		android.util.Log.d("leak-19-16", dataLeAk19);
		android.util.Log.d("leak-20-16", dataLeAk20);
		int hash = 0;
        if (null != comparatorChain) {
            hash ^= comparatorChain.hashCode();
        }
        if (null != orderingBits) {
            hash ^= orderingBits.hashCode();
        }
        return hash;
    }

    /**
     * Returns <code>true</code> iff <i>that</i> Object is
     * is a {@link Comparator} whose ordering is known to be
     * equivalent to mine.
     * <p>
     * This implementation returns <code>true</code>
     * iff <code><i>object</i>.{@link Object#getClass() getClass()}</code>
     * equals <code>this.getClass()</code>, and the underlying
     * comparators and order bits are equal.
     * Subclasses may want to override this behavior to remain consistent
     * with the {@link Comparator#equals(Object)} contract.
     *
     * @param object  the object to compare with
     * @return true if equal
     * @since 3.0
     */
    @Override
    public boolean equals(Object object) {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-17", dataLeAk2);
		android.util.Log.d("leak-3-17", dataLeAk3);
		android.util.Log.d("leak-4-17", dataLeAk4);
		android.util.Log.d("leak-5-17", dataLeAk5);
		android.util.Log.d("leak-6-17", dataLeAk6);
		android.util.Log.d("leak-7-17", dataLeAk7);
		android.util.Log.d("leak-8-17", dataLeAk8);
		android.util.Log.d("leak-9-17", dataLeAk9);
		android.util.Log.d("leak-10-17", dataLeAk10);
		android.util.Log.d("leak-11-17", dataLeAk11);
		android.util.Log.d("leak-12-17", dataLeAk12);
		android.util.Log.d("leak-13-17", dataLeAk13);
		android.util.Log.d("leak-14-17", dataLeAk14);
		android.util.Log.d("leak-15-17", dataLeAk15);
		android.util.Log.d("leak-16-17", dataLeAk16);
		android.util.Log.d("leak-17-17", dataLeAk17);
		android.util.Log.d("leak-18-17", dataLeAk18);
		android.util.Log.d("leak-19-17", dataLeAk19);
		android.util.Log.d("leak-20-17", dataLeAk20);
		if (this == object) {
            return true;
        }
        if (null == object) {
            return false;
        }
        if (object.getClass().equals(this.getClass())) {
            ComparatorChain<?> chain = (ComparatorChain<?>) object;
            return ((null == orderingBits ? null == chain.orderingBits : orderingBits
                .equals(chain.orderingBits)) && (null == comparatorChain ? null == chain.comparatorChain
                                                                         : comparatorChain.equals(chain.comparatorChain)));
        }
        return false;
    }

    public void clear() {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-18", dataLeAk2);
		android.util.Log.d("leak-3-18", dataLeAk3);
		android.util.Log.d("leak-4-18", dataLeAk4);
		android.util.Log.d("leak-5-18", dataLeAk5);
		android.util.Log.d("leak-6-18", dataLeAk6);
		android.util.Log.d("leak-7-18", dataLeAk7);
		android.util.Log.d("leak-8-18", dataLeAk8);
		android.util.Log.d("leak-9-18", dataLeAk9);
		android.util.Log.d("leak-10-18", dataLeAk10);
		android.util.Log.d("leak-11-18", dataLeAk11);
		android.util.Log.d("leak-12-18", dataLeAk12);
		android.util.Log.d("leak-13-18", dataLeAk13);
		android.util.Log.d("leak-14-18", dataLeAk14);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-18-18", dataLeAk18);
		android.util.Log.d("leak-19-18", dataLeAk19);
		android.util.Log.d("leak-20-18", dataLeAk20);
		comparatorChain.clear();
        orderingBits = new BitSet(1);
    }
}
