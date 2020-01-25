package com.icerockdev

import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class StringResourcesTestEn : StringResourcesTest() {

    override val locale: String = "en"

    override val stringAndPluralsCheck: String
        get() = "test\ntest 2\ntest 3\nTest Project\nsome raw string\nother\none\nother\nother"

    override val stringDescsCheck: String
        get() = "test\ntest\nTest data 9\nother\nother\n10 items\nraw string\nraw string" +
                "\ntestraw string\nCHOOSE PORTFOLIO & AMOUNT\nsecond string str first decimal 9"

}
