package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.LargeInt;
import a1.LargeIntInterface;
import org.junit.jupiter.api.Test;

class LargeIntHUGENumbersTest {

    @Test
    void testHUGESumMeNegative_1() {
        String meValue = "-2387230952375237324734672347657284782587724564785854828523478524523465276835828375";
        String me2Value = "228928929895898958938923895895389598589893589523893528958923895328958935892358952823835892895382539855757934279727";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("228928929895898958938923895895387211358941214286568794286576238044176348167794166969007369416858016390481098451352", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGESumMeNegative_2() {
        String meValue = "237283472134723070237507235702307523070723752307520783057820357023032203082332";
        String me2Value = "-23626352368235623952395293572379572935725072057275204520480852485823580203850823580230850820525304785223523070273";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-23626352368235623952395293572379572698441599922552134282973616783516057133127071272710067762704947762191319987941", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGESum2Negatives() {
        String meValue = "-94899384934238723788742783723787882378782783757238785278378237857626348562486568246526485682468568234656824682345623568523668235";
        String me2Value = "-4756237642357457234235742375745234523574523452357452374523574235457235723575234455234574235723577523523457423573457234";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-94899384938994961431100240958023624754528018280813308730735690232149922797943803970101720137703142470380402205869080992097125469", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }



    @Test
    void testHUGEDiffMeNegative_1() {
        String meValue = "-2387230952375237324734672347657284782587724564785854828523478524523465276835828375";
        String me2Value = "228928929895898958938923895895389598589893589523893528958923895328958935892358952823835892895382539855757934279727";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-228928929895898958938923895895391985820845964761218263631271552613741523616923738678664416373907063321034770108102", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }


    @Test
    void testHUGEDiffMeNegative_2() {
        String meValue = "237283472134723070237507235702307523070723752307520783057820357023032203082332";
        String me2Value = "-23626352368235623952395293572379572935725072057275204520480852485823580203850823580230850820525304785223523070273";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("23626352368235623952395293572379573173008544191998274757988088188131103274574575887751633878345661808255726152605", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGEDiff2Negatives() {
        String meValue = "-94899384934238723788742783723787882378782783757238785278378237857626348562486568246526485682468568234656824682345623568523668235";
        String me2Value = "-4756237642357457234235742375745234523574523452357452374523574235457235723575234455234574235723577523523457423573457234";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-94899384929482486146385326489552140003037549233664261826020785483102774327029332522951251227233993998933247158822166144950211001", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGESum2Pos() {
        String meValue = "23783743841734789134626343768437462378463784623487378439324983992372394379491347473927413794791374979314792379479234792379423794792379473923689423689428346";
        String me2Value = "9929297433971793793714012074237124791247177694913723794791374379273792317945237947923794237952357463647723463564523574723545235742357237682346";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("23783743841744718432060315562231176390538021748278625617019897716167185753870621266245359032739298773552744736942882515842988318367103019159431780927110692", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGEDiff2Pos_1() {
        String meValue = "23783743841734789134626343768437462378463784623487378439324983992372394379491347473927413794791374979314792379479234792379423794792379473923689423689428346";
        String me2Value = "9929297433971793793714012074237124791247177694913723794791374379273792317945237947923794237952357463647723463564523574723545235742357237682346";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("23783743841724859837192371974643748366389547498696131261630070268577603005112073681609468556843451185076840022015587068915859271217655928687947066451746000", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testHUGEDiff2Pos() {
        String meValue = "23783743841734789134626343768437462378463784623487378439324983992372394379491347473927413794791374979314792379479234792379423794792379473923689423689428346";
        String me2Value = "23783743841734789134626343768437462378463784623487378439324983992372394379491347473927413794791374979314792379479234792379423794792379473923689423689425000";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("3346", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }









}