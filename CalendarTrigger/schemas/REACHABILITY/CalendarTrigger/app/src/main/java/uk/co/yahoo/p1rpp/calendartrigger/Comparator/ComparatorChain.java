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

    String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

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
		String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
    }

    /**
     * Construct a ComparatorChain with a single Comparator,
     * sorting in the forward order
     *
     * @param comparator First comparator in the Comparator chain
     */
    public ComparatorChain(Comparator<E> comparator) {
        this(comparator, false);
		String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
    }

    /**
     * Construct a Comparator chain with a single Comparator,
     * sorting in the given order
     *
     * @param comparator First Comparator in the ComparatorChain
     * @param reverse    false = forward sort; true = reverse sort
     */
    public ComparatorChain(Comparator<E> comparator, boolean reverse) {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
		comparatorChain = new ArrayList<Comparator<E>>(1);
        comparatorChain.add(comparator);
        orderingBits = new BitSet(1);
        if (reverse == true) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
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
		String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
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
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
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
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
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
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
		checkLocked();

        comparatorChain.add(comparator);
        if (reverse == true) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
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
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
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
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
		checkLocked();

        comparatorChain.set(index,comparator);
        if (reverse == true) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
			orderingBits.set(index);
        } else {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
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
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
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
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		checkLocked();
        orderingBits.set(index);
    }

    /**
     * Number of Comparators in the current ComparatorChain.
     *
     * @return Comparator count
     */
    public int size() {
        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
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
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
		return isLocked;
    }

    /**
     * Throws an exception if the {@link ComparatorChain} is locked.
     *
     * @throws UnsupportedOperationException if the {@link ComparatorChain} is locked
     */
    private void checkLocked() {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
		if (isLocked == true) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
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
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
		if (comparatorChain.size() == 0) {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
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
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
		if (isLocked == false) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
			checkChainIntegrity();
            isLocked = true;
        }

        // iterate over all comparators in the chain
        Iterator<Comparator<E>> comparators = comparatorChain.iterator();
        for (int comparatorIndex = 0; comparators.hasNext(); ++comparatorIndex) {

            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
			Comparator<E> comparator = comparators.next();
            int retval = comparator.compare(o1,o2);
            if (retval != 0) {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
				// invert the order if it is a reverse sort
                if (orderingBits.get(comparatorIndex) == true) {
                    String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
					if(Integer.MIN_VALUE == retval) {
                        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
						retval = Integer.MAX_VALUE;
                    } else {
                        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
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
        String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
		int hash = 0;
        if (null != comparatorChain) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
			hash ^= comparatorChain.hashCode();
        }
        if (null != orderingBits) {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
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
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
		if (this == object) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
			return true;
        }
        if (null == object) {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
			return false;
        }
        if (object.getClass().equals(this.getClass())) {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
			ComparatorChain<?> chain = (ComparatorChain<?>) object;
            return ((null == orderingBits ? null == chain.orderingBits : orderingBits
                .equals(chain.orderingBits)) && (null == comparatorChain ? null == chain.comparatorChain
                                                                         : comparatorChain.equals(chain.comparatorChain)));
        }
        return false;
    }

    public void clear() {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
		comparatorChain.clear();
        orderingBits = new BitSet(1);
    }
}
