import { Component, OnInit } from '@angular/core';
import { NewsItem } from '../../models/news-item.model';
import { NewsService } from '../../services/news.service';

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
      (data: NewsItem[]) => {
        this.newsItems = data;
        this.errorMessage = null;
      },
      (error: any) => {
        this.newsItems = [];
        this.errorMessage = 'Error fetching news';
        console.error('Error fetching news', error);
      }
    );
  }

  onDateChange(event: any): void {
    const selectedDate = event.target.value;
    if (selectedDate) {
      this.filterDate = selectedDate;
      this.fetchNews();
    } else {
      this.errorMessage = 'Invalid date';
    }
  }
}
