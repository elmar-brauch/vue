<script setup lang="ts">
import axios from "axios";
import { ref } from 'vue';

const props = defineProps<{
  headline: string,
  carApiUrl: string
}>()

class Car {
  public make: string
  public model: string

  constructor(make: string, model: string) {
    this.make = make;
    this.model = model;
  }

  public isValid(): boolean {
    return this.make.length > 0 && this.model.length > 0
  }

  storeCar(): void {
      if (this.isValid())
          axios.post(props.carApiUrl, this)
  }
}

const cars = ref([] as Car[])
const newCar = ref(new Car("", ""))

async function readCars() {
    cars.value = (await axios.get<Car[]>(props.carApiUrl)).data
}
</script>

<template>
  <div>
    <h1>{{ headline }}</h1>
    <h2>
        <ul v-if="cars.length > 0">
            <li v-for="car in cars">{{ car.make }} {{ car.model }}</li>
        </ul>
        <label v-else>No cars</label>
    </h2>
    <button @click="readCars">Read cars</button>
    <h2>
        <label>Car Make: </label>
        <input v-model="newCar.make" type="text" required>
        <br/>
        <label>Car Model: </label>
        <input v-model="newCar.model" type="text" required>
        <br/>
        <div v-if="!newCar.isValid()">
            <label>Please fill both input fields.</label>
        </div>
    </h2>
    <button @click="newCar.storeCar">Store car</button>
  </div>
</template>

<style scoped>
</style>
