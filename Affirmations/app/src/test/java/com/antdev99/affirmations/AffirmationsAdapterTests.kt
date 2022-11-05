package com.antdev99.affirmations

import com.antdev99.affirmations.adapters.ItemAdapter
import com.antdev99.affirmations.model.Affirmation
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {
    private val context = mock(MainActivity::class.java)

    @Test
    private fun test_adapter_size(){
        val data = listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context, data)

        assertEquals("Incorrect size", data, adapter.itemCount)
    }
}