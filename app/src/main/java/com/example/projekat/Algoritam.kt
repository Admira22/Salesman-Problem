package com.example.projekat

import com.example.projekat.model.City
import com.example.projekat.repository.CityRepository

class Algoritam(pocetniGradId: Int) {
    private var trenutnaNajmanjaUdaljenost: Double = 0.0
    var trenutnaNajkracaRuta: MutableList<City> = mutableListOf()

    init {
        val gradovi = CityRepository().getAllData()
        val pocetniGrad = gradovi.find { it.id == pocetniGradId }

        if (pocetniGrad != null) {
            trenutnaNajmanjaUdaljenost = izracunajUkupnuUdaljenost(gradovi)
            trenutnaNajkracaRuta = gradovi.toMutableList()

            zamijeniElemente(trenutnaNajkracaRuta, 0, gradovi.indexOf(pocetniGrad))

            permutacije(trenutnaNajkracaRuta, 1, trenutnaNajmanjaUdaljenost, trenutnaNajkracaRuta)
        }
    }

    private fun izracunajUkupnuUdaljenost(gradovi: List<City>): Double {
        var ukupnaUdaljenost = 0.0

        for (i in 0 until gradovi.size - 1) {
            ukupnaUdaljenost += gradovi[i].izracunajUdaljenost(gradovi[i + 1])
        }

        return ukupnaUdaljenost
    }

    private fun zamijeniElemente(gradovi: MutableList<City>, x: Int, y: Int) {
        val temp = gradovi[x]
        gradovi[x] = gradovi[y]
        gradovi[y] = temp
    }

    private fun permutacije(gradovi: MutableList<City>, indeks: Int, minUdaljenost: Double, najboljaRuta: MutableList<City>) {
        if (indeks == gradovi.size) {
            val rez = izracunajUkupnuUdaljenost(gradovi)

            if (rez < minUdaljenost) {
                trenutnaNajmanjaUdaljenost = rez
                trenutnaNajkracaRuta = gradovi.toMutableList()
            }
            return
        }

        for (i in indeks until gradovi.size) {
            zamijeniElemente(gradovi, i, indeks)
            permutacije(gradovi, indeks + 1, trenutnaNajmanjaUdaljenost, trenutnaNajkracaRuta)
            zamijeniElemente(gradovi, i, indeks)
        }
    }
}
