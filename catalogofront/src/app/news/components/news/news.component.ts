import { Component, OnInit } from '@angular/core';
import { NewsService } from '../services/news.service';
import { NewsItem } from '../models/news-item.model';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  newsItems: NewsItem[] = [];
  errorMessage: string | null = null;
  filterDate: string = '2021-01-01 00:00:00';

  constructor(private newsService: NewsService) {}

  ngOnInit(): void {
    this.fetchNews();
  }

  fetchNews(): void {
    this.newsService.getLatestNews(this.filterDate).subscribe(
      (data) => {
        this.newsItems = data;
        this.errorMessage = null;
      },
      (error) => {
        this.newsItems = [];
        this.errorMessage = 'Error fetching news';
        console.error('Error fetching news', error);
      }
    );
  }

  onDateChange(event: any): void {
    this.filterDate = event.target.value;
    this.fetchNews();
  }
}
