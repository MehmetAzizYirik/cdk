/*
 * Copyright (c) 2017 John Mayfield <jwmay@users.sf.net>
 *
 * Contact: cdk-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or (at
 * your option) any later version. All we ask is that proper credit is given
 * for our work, which includes - but is not limited to - adding the above
 * copyright notice to the beginning of your source code files, and to any
 * copyright notice that you may distribute with programs based on this work.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */

package org.openscience.cdk.stereo;

import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IStereoElement;

import java.util.List;

/**
 * Represents an octahedral configuration of an atom six neighbors. The
 * configuration order is defined as between 1 and 30 using the same permutation
 * tables as SMILES (e.g. @OH1 .. @OH30). This allows the 720 permutations of
 * atom ordering to be described.
 * <br>
 * Normalizing the representation (with {@link #normalize()} returns a
 * configuration reordered such that the configuration order is 1. For example
 * <pre>C[Co@OH8](F)(Br)(Cl)(I)S</pre>
 * is the same as
 * <pre>C[Co@OH1](F)(Cl)(Br)(I)S</pre>. The normalised form is easy to work
 * with as the first and last carriers form an axis, the middle four equatorial
 * carriers are arranged anti-clockwise looking from the first carrier.
 *
 * <pre>
 *      c
 *      | a
 *      |/
 *  d---x---b = OH1
 *     /|       where a: first carrier, b: second carried, etc
 *    f |             x: focus
 *      e             'a' is in front of the focus 'x', 'f' is behind
 * </pre>
 *
 * @see <a href="http://opensmiles.org/opensmiles.html#_octahedral_centers">
 *     Octahedral Centers, OpenSMILES</a>
 * @see TrigonalBipyramidal
 * @see SquarePlanar
 */
public final class Octahedral extends AbstractStereo<IAtom,IAtom> {

    private static String superperm =
        "123456123451623451263451236451326451362451364251364521364512" +
        "346512341562341526341523641523461523416523412563412536412534" +
        "612534162534126534123564123546123541623541263541236541326543" +
        "126453162435162431562431652431625431624531642531462531426531" +
        "425631425361425316452314652314562314526314523614523164532164" +
        "531264351264315264312564321564231546231542631542361542316542" +
        "315642135642153624153621453621543621534621354621345621346521" +
        "346251346215364215634216534216354216345216342516342156432516" +
        "432561432564132564312654321654326153426135426134526134256134" +
        "265134261532465132465312463512463152463125463215463251463254" +
        "163254613254631245632145632415632451632456132456312465321465" +
        "324165324615326415326145326154326514362514365214356214352614" +
        "352164352146352143651243615243612543612453612435612436514235" +
        "614235164235146235142635142365143265413625413652413562413526" +
        "41352461352416352413654213654123";
    // OH1 = 1, OH2 = 2, OH3 = 3, ..., OH10=a, OH11=b, ...,  OH30=u
    private static String config_ids = "123456789abcdefghijklmnopqrstu";
    private static String config =
        "1u9fnm hdsq32 6eabu7 jn5r 7ptglc 189oih 45kqp2 sl3b8e di l3t" +
        "8eo  ka46gm qrd9jn u7feat 1gicrp ljb572  3fhuom 9cr41g at67f" +
        "b kopsc8 l1eitn  j6qa2m 4schko fbut6e 328ds5 lk7p 5rqi phc 1" +
        "mr gq 9anmru d72ejb 6gfkac trl17i pj45 ihn8 5e2ldb suo63f tn" +
        "71er admjuq 93 dm2 s48khp 59jiqr gmca4f 1hno93 uq6 s4okhc f9" +
        "a gqkj42 6husm3 d95n 3loe nfr 7clgtp io981h 4fkmc6 st3boe u1" +
        "a 7cbgtk 6o cbptkl 8235sd e67uba jkqg a9frm1 chpo48 iqn59d 3" +
        "msuh6 24 msfh 41p9 h53q8d nlrei7 jp2g5k b8tslo ci 8t 1prcig " +
        "75bjl2 k84sph qi 84o 1mnf9u 3q mna9 qg54jp i71lrt cakfg6 bje" +
        "27d ur je na1urf tgbc fsmo6h 42pqk5 8b3l 5njidr 7utaef 139on" +
        "h md6qu2 se d6j 7klgbp 5sq82h 46cmkf ob3tse u2a 7k 6jm2aq 4r" +
        "p9gi 57dl i318no tubfe6 sdh2 64a j9drqn uhf3 ntie1l 8cspok b" +
        "f76ta g14rc9 mo 14ic olst8b k5g2pj 7ierln d8q35h 9p 8q 4ig9p" +
        "r jld75e n813io tpbclk s5h2 kmg j9 4acmgf 17nt f36ous bdl2e5" +
        " 8nhi39 qujmda re uj6da2 bg";

    /**
     * Create a new octahedral configuration.
     * @param focus    the focus
     * @param carriers the carriers
     * @param order    the order of the configuration 0-30.
     */
    public Octahedral(IAtom focus, IAtom[] carriers, int order) {
        super(focus, carriers, IStereoElement.OC | (order & 0xff));
        if (getConfigOrder() < 0 || getConfigOrder() > 30)
            throw new IllegalArgumentException("Invalid configuration order!"
                                               + "Should be in range 1-30");
    }

    /**
     * Normalize the configuration to the lowest order (1). For example
     * <pre>C[Co@OH8](F)(Br)(Cl)(I)S</pre>
     * is the same as
     * <pre>C[Co@OH1](F)(Cl)(Br)(I)S</pre>. The normalised form is easy to
     * work with as the first and last carriers form an axis, the middle four
     * equatorial carriers are arranged anti-clockwise looking from the first carrier.
     * @return the normalized form
     */
    public Octahedral normalize() {
        int cfg = getConfigOrder();
        if (cfg == 1)
          return this;
        if (cfg < 1 || cfg > 30)
            throw new IllegalArgumentException(
                "Invalid config order: " + cfg + ", octahedral should be"
                + "1 <= order <= 30!");
        char c  = config_ids.charAt(cfg-1);
        int idx = config.indexOf(c);
        IAtom[] carriers = invapply(getCarriers().toArray(new IAtom[6]),
                                    superperm.substring(idx, idx+6));
        return new Octahedral(getFocus(), carriers, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Octahedral create(IAtom focus, List<IAtom> carriers, int cfg) {
        return new Octahedral(focus,
                              carriers.toArray(new IAtom[6]),
                              cfg);
    }
}
