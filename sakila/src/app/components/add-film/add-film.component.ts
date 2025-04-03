import {Component, Input, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';
import {MovieFormService} from '../../services/movie-form.service';
import {Movie, Rating} from '../../model/movie';
import {Language} from '../../model/language';


@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {

  addFilmFormGroup!: FormGroup;

  @Input()
  currentMovie!: Movie;
  languages: Language[] = [];
  releaseYears: number[] = [];

  currentRating = Rating;
  enumKeys: string[] = [];
  features = [];
  selectedFeatures = [];


  constructor(private formBuilder: FormBuilder, private movieFormService: MovieFormService) {
    this.enumKeys = Object.keys(this.currentRating);
  }


  ngOnInit(): void {

    this.movieFormService.getAllSpecialFeatures().subscribe(data => {
      this.features = data;
    });

    this.addFilmFormGroup = this.formBuilder.group({
      film: this.formBuilder.group({
        title: [''],
        description: [''],
        releaseYear: [''],
        rentalDuration: [''],
        language: [''],
        rentalRate: [''],
        length: [''],
        replacementCost: [''],
        specialFeatures: this.addSpecialFeaturesControls(),
        lastUpdate: [''],
        rating: ['']
      })
    });
    this.movieFormService.getCreditCardYears().subscribe(data => {
      this.releaseYears = data;
    });
    this.movieFormService.getAllLanguage().subscribe(data => {
      this.languages = data;
    });

  }

  onSubmit() {
    console.log('Handing the submit button');
    console.log(this.selectedFeatures);
    const currentDate = new Date();
    const saveMovie = new Movie(0,
      this.addFilmFormGroup.get('film.title')?.value ?? '',
      this.addFilmFormGroup.get('film.description')?.value ?? '',
      this.addFilmFormGroup.get('film.releaseYear')?.value ?? '',
      this.addFilmFormGroup.get('film.language')?.value ?? '',
      this.addFilmFormGroup.get('film.length')?.value ?? '',,
      this.selectedFeatures.join(),
      currentDate,
      this.addFilmFormGroup.get('film.rating')?.value ?? '',
      [],
      this.addFilmFormGroup.get('film.lastUpdate')?.value ?? ''
    );


    this.movieFormService.addNewFilm(saveMovie).subscribe(response => {
      console.log(response);
    });
  }

  get specialFeaturesArray() {
    return this.addFilmFormGroup.get('film.specialFeatures') as FormArray;
  }

  getSelectedFeaturesValue() {
    this.selectedFeatures = [];
    this.specialFeaturesArray.controls.forEach((control, i) => {
      if (control.value) {
        this.selectedFeatures.push(this.features[i]);
      }
    });

    console.log(this.selectedFeatures);
  }

  addSpecialFeaturesControls() {
    const arr = this.features.map(element => {
      return this.formBuilder.control(false);
    });
    return this.formBuilder.array(arr);
  }

}
