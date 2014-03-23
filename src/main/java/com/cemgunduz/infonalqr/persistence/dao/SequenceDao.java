package com.cemgunduz.infonalqr.persistence.dao;

import com.cemgunduz.infonalqr.persistence.dao.constants.Sequence;

/**
 * Created by cgunduz on 3/14/14.
 */
public interface SequenceDao {

    public long nextSequence(Sequence sequence);
}
