package com.emoor.glidee.manager;

import com.emoor.glidee.RequestManager;

import java.util.Collections;
import java.util.Set;

/**
 * A {@link RequestManagerTreeNode} that returns no relatives.
 */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
