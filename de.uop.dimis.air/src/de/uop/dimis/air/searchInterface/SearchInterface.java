/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uop.dimis.air.searchInterface;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 *
 * @author stegmai
 */
public interface SearchInterface {

    MpegQueryType execute(MpegQueryType qry);
}
